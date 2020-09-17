package br.com.zup.bootcamp.proposta.write.application.service;

import java.util.UUID;

public class CreateProposalCommand implements Command {

    private final UUID externalId;
    private final String identityDocument;
    private final String email;
    private final String name;
    private final Double salary;
    private final String address;

    public CreateProposalCommand(String identityDocument,
                                 String email,
                                 String name,
                                 Double salary,
                                 String address) {
        externalId = UUID.randomUUID();
        this.identityDocument = identityDocument;
        this.email = email;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }
}
