package br.com.zup.bootcamp.proposta.write.application.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Proposal {

    private Long id;
    private UUID externalId;
    private String identityDocument;
    private String email;
    private String name;
    private Double salary;
    private String street;
    private String streetNumber;
    private String secondaryAddress;
    private String city;
    private String state;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Long getId() {
        return id;
    }

    public Proposal setId(Long id) {
        this.id = id;
        return this;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public Proposal setExternalId(UUID externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public Proposal setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Proposal setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public Proposal setName(String name) {
        this.name = name;
        return this;
    }

    public Double getSalary() {
        return salary;
    }

    public Proposal setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Proposal setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public Proposal setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public Proposal setSecondaryAddress(String secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Proposal setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Proposal setState(String state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Proposal setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public Proposal setUpdated(LocalDateTime updated) {
        this.updated = updated;
        return this;
    }
}
