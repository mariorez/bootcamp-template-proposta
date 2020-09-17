package br.com.zup.bootcamp.proposta.write.application.domain;

import java.util.Optional;
import java.util.UUID;

public interface WriteProposalRepository {

    void create(Proposal proposal);

    Optional<Proposal> findByExternalId(UUID externalId);
}
