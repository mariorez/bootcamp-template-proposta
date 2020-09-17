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
        var address = faker.address().fullAddress();

        var command = new CreateProposalCommand(
                identityDocument,
                email,
                name,
                salary,
                address);

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
        assertThat(address).isEqualTo(expectedProposal.getAddress());
    }
}
