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
    private String address;
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

    public String getAddress() {
        return address;
    }

    public Proposal setAddress(String address) {
        this.address = address;
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
