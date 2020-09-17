package br.com.zup.bootcamp.proposta.write.adapter.out;

import br.com.zup.bootcamp.proposta.write.application.domain.Proposal;
import br.com.zup.bootcamp.proposta.write.application.domain.WriteProposalRepository;
import helper.DataSourceHelper;
import helper.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("unit")
public class WriteProposalRepositoryImplTest extends TestHelper {

    private WriteProposalRepositoryImpl repository;

    @BeforeEach
    void setup() {
        repository = new WriteProposalRepositoryImpl(new DataSourceHelper());
    }

    @Test
    void MUST_ImplementInterface() {
        assertThat(repository).isInstanceOf(WriteProposalRepository.class);
    }

    @Test
    void WHEN_CreatingProposal_GIVEN_ValidData_MUST_PersistOnDatabase() {

        // GIVEN
        var expected = new Proposal()
                .setExternalId(UUID.randomUUID())
                .setIdentityDocument(faker.number().digits(8))
                .setEmail(faker.internet().emailAddress())
                .setName(faker.dragonBall().character())
                .setSalary((Double) faker.number().randomDouble(2, 3, 6))
                .setAddress(faker.address().fullAddress());

        // WHEN
        repository.create(expected);

        // THEN
        var actual = repository.findByExternalId(expected.getExternalId()).get();
        assertThat(actual.getId()).isGreaterThan(0);
        assertThat(actual.getExternalId()).isEqualTo(expected.getExternalId());
        assertThat(actual.getIdentityDocument()).isEqualTo(expected.getIdentityDocument());
        assertThat(actual.getEmail()).isEqualTo(expected.getEmail());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getSalary()).isEqualTo(expected.getSalary());
        assertThat(actual.getAddress()).isEqualTo(expected.getAddress());
        assertThat(actual.getCreated()).isBeforeOrEqualTo(LocalDateTime.now());
        assertThat(actual.getUpdated()).isBeforeOrEqualTo(LocalDateTime.now());
    }
}
