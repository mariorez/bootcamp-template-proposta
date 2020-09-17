package br.com.zup.bootcamp.proposta.write.adapter.in;

import br.com.zup.bootcamp.proposta.common.ServiceBus;
import br.com.zup.bootcamp.proposta.write.application.service.CreateProposalCommand;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class WriteProposalResource {

    public static final String RESOURCE = "/v1/proposals";

    private ServiceBus serviceBus;

    public WriteProposalResource(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @PostMapping(value = RESOURCE)
    public ResponseEntity<String> create(@RequestBody ProposalInput input) {

        var command = new CreateProposalCommand(
                input.identityDocument,
                input.email,
                input.name,
                input.salary,
                input.street,
                input.streetNumber,
                input.secondaryAddress,
                input.city,
                input.state);

        serviceBus.execute(command);

        return ResponseEntity
                .status(CREATED)
                .header("Location", String.format("%s/%s", RESOURCE, command.getExternalId()))
                .build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class ProposalInput {
        @JsonProperty("identityDocument")
        String identityDocument;
        @JsonProperty("email")
        String email;
        @JsonProperty("name")
        String name;
        @JsonProperty("salary")
        Double salary;
        @JsonProperty("street")
        String street;
        @JsonProperty("streetNumber")
        String streetNumber;
        @JsonProperty("secondaryAddress")
        String secondaryAddress;
        @JsonProperty("city")
        String city;
        @JsonProperty("state")
        String state;
    }
}
