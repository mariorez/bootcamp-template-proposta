package br.com.zup.bootcamp.proposta.common;

import br.com.zup.bootcamp.proposta.write.application.service.Command;
import br.com.zup.bootcamp.proposta.write.application.service.Handler;
import br.com.zup.bootcamp.proposta.write.observer.CommandEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ServiceBus {

    private ApplicationContext context;
    private ApplicationEventPublisher publisher;

    public ServiceBus(ApplicationContext context, ApplicationEventPublisher publisher) {
        this.context = context;
        this.publisher = publisher;
    }

    public void execute(Command command) {
        var event = new CommandEvent(command);
        execute(event);
    }

    private void execute(InternalEvent event) {

        try {
            run(event);
        } catch (Exception exception) {
            event.setException(exception);
            throw exception;
        } finally {
            event.stopTimer();
            publisher.publishEvent(event);
        }
    }

    private void run(InternalEvent event) {

        var beanName = event.getOrigin().substring(0, 1).toLowerCase() + event.getOrigin().substring(1);

        switch (event.getType()) {

            case COMMAND:
                var handlerBeanName = beanName.replace("Command", "Handler");
                Handler<Command> handler = (Handler) context.getBean(handlerBeanName);
                handler.handle((Command) event.getSource());
                break;

            case QUERY:
                break;

            default:
                throw new ServiceBusInvalidObjectException(event);
        }
    }
}
