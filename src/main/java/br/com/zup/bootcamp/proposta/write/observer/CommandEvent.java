package br.com.zup.bootcamp.proposta.write.observer;

import br.com.zup.bootcamp.proposta.common.DomainException;
import br.com.zup.bootcamp.proposta.common.InternalEvent;
import br.com.zup.bootcamp.proposta.write.application.service.Command;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class CommandEvent extends InternalEvent {

    private final Command command;

    public CommandEvent(Command command) {
        startTimer();
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    @Override
    public Object getSource() {
        return getCommand();
    }

    public String toJson() {

        try {
            var mapper = new ObjectMapper();
            Map<String, Object> message = new HashMap<>(Map.of("origin", getOrigin()));
            message.put("content", getCommand());
            message.put("elapsedTimeInMilli", getElapsedTimeInMilli());

            if (hasError()) {
                message.put("message", getException().getMessage());

                if (isDomainException()) {
                    var domainException = (DomainException) getException();
                    if (domainException.hasError()) message.put("errors", domainException.getErrors().toString());
                }
            }

            return mapper.writeValueAsString(message);

        } catch (JsonProcessingException jsonException) {
            return String.format("content:%s, error:%s", getCommand(), jsonException);
        }
    }
}
