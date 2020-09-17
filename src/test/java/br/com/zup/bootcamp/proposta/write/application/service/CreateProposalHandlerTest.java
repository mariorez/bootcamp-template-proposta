package br.com.zup.bootcamp.proposta.write.application.service;

import br.com.zup.bootcamp.proposta.write.application.domain.Proposal;
import br.com.zup.bootcamp.proposta.write.application.domain.WriteProposalRepository;
import helper.TestHelper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@Tag("unit")
public class CreateProposalHandlerTest extends TestHelper {

    private ArgumentCaptor<Proposal> captor = ArgumentCaptor.forClass(Proposal.class);

    @Test
    void GIVEN_ValidData_MUST_CreateProposal() {

        // GIVEN
        var identityDocument = faker.number().digits(8);
        var email = faker.internet().emailAddress();
        var name = faker.dragonBall().character();
        var salary = (Double) faker.number().randomDouble(2, 3, 6);
        var street = faker.address().streetName();
        var streetNumber = faker.address().streetAddressNumber();
        var secondaryAddress = faker.address().secondaryAddress();
        var city = faker.address().city();
        var state = faker.address().stateAbbr();

        var command = new CreateProposalCommand(
                identityDocument,
                email,
                name,
                salary,
                street,
                streetNumber,
                secondaryAddress,
                city,
                state);

        var proposalRepository = mock(WriteProposalRepository.class);

        // WHEN
        var handler = new CreateProposalHandler(proposalRepository);
        handler.handle(command);

        // THEN
        verify(proposalRepository).create(captor.capture());
        var expectedProposal = captor.getValue();
        assertThat(expectedProposal.getExternalId()).isEqualTo(command.getExternalId());
        assertThat(identityDocument).isEqualTo(expectedProposal.getIdentityDocument());
        assertThat(email).isEqualTo(expectedProposal.getEmail());
        assertThat(name).isEqualTo(expectedProposal.getName());
        assertThat(salary).isEqualTo(expectedProposal.getSalary());
        assertThat(street).isEqualTo(expectedProposal.getStreet());
        assertThat(streetNumber).isEqualTo(expectedProposal.getStreetNumber());
        assertThat(secondaryAddress).isEqualTo(expectedProposal.getSecondaryAddress());
        assertThat(city).isEqualTo(expectedProposal.getCity());
        assertThat(state).isEqualTo(expectedProposal.getState());
    }
}
