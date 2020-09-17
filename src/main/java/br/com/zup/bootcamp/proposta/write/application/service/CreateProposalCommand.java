package br.com.zup.bootcamp.proposta.write.application.service;

import br.com.zup.bootcamp.proposta.common.SelfValidation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.UUID;

public class CreateProposalCommand implements Command, SelfValidation {

    private final UUID externalId;
    @NotBlank
    private final String identityDocument;
    @Email
    private final String email;
    @NotBlank
    private final String name;
    @Positive
    private final Double salary;
    @NotBlank
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
        selfValidate();
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
