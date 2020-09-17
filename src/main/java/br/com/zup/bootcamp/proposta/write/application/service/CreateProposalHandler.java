package br.com.zup.bootcamp.proposta.write.application.service;

import br.com.zup.bootcamp.proposta.write.application.domain.Proposal;
import br.com.zup.bootcamp.proposta.write.application.domain.WriteProposalRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProposalHandler implements Handler<CreateProposalCommand> {

    private final WriteProposalRepository proposalRepository;

    public CreateProposalHandler(WriteProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    public void handle(CreateProposalCommand command) {

        var proposal = new Proposal()
                .setExternalId(command.getExternalId())
                .setIdentityDocument(command.getIdentityDocument())
                .setEmail(command.getEmail())
                .setName(command.getName())
                .setSalary(command.getSalary())
                .setAddress(command.getAddress());

        proposalRepository.create(proposal);
    }
}
