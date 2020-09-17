package br.com.zup.bootcamp.proposta.write.application.service;

import java.util.UUID;

public class CreateProposalCommand {

    private final UUID externalId;
    private final String identityDocument;
    private final String email;
    private final String name;
    private final Double salary;
    private final String street;
    private final String streetNumber;
    private final String secondaryAddress;
    private final String city;
    private final String state;

    public CreateProposalCommand(String identityDocument,
                                 String email,
                                 String name,
                                 Double salary,
                                 String street,
                                 String streetNumber,
                                 String secondaryAddress,
                                 String city,
                                 String state) {
        externalId = UUID.randomUUID();
        this.identityDocument = identityDocument;
        this.email = email;
        this.name = name;
        this.salary = salary;
        this.street = street;
        this.streetNumber = streetNumber;
        this.secondaryAddress = secondaryAddress;
        this.city = city;
        this.state = state;
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

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
