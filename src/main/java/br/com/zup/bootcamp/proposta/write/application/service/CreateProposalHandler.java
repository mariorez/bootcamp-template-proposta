package br.com.zup.bootcamp.proposta.write.application.service;

import br.com.zup.bootcamp.proposta.write.application.domain.Proposal;
import br.com.zup.bootcamp.proposta.write.application.domain.WriteProposalRepository;

import java.util.UUID;

public class CreateProposalHandler {

    private final WriteProposalRepository proposalRepository;

    public CreateProposalHandler(WriteProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    public void handle(CreateProposalCommand command) {

        var proposal = new Proposal()
                .setExternalId(UUID.randomUUID())
                .setIdentityDocument(command.getIdentityDocument())
                .setEmail(command.getEmail())
                .setName(command.getName())
                .setSalary(command.getSalary())
                .setStreet(command.getStreet())
                .setStreetNumber(command.getStreetNumber())
                .setSecondaryAddress(command.getSecondaryAddress())
                .setCity(command.getCity())
                .setState(command.getState());

        proposalRepository.create(proposal);
    }
}
