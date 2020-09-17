package br.com.zup.bootcamp.proposta.write.application.service;

public interface Handler<T extends Command> {

    void handle(T command);
}
