package br.com.zup.bootcamp.proposta.write.adapter.out;

import br.com.zup.bootcamp.proposta.write.application.domain.Proposal;
import br.com.zup.bootcamp.proposta.write.application.domain.WriteProposalRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;
import java.util.UUID;

@Repository
public class WriteProposalRepositoryImpl implements WriteProposalRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public WriteProposalRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void create(Proposal proposal) {
        var sql = "INSERT INTO proposal(external_id, identity_document, email, name, salary, address) " +
                "values (:external_id, :identity_document, :email, :name, :salary, :address)";

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("external_id", proposal.getExternalId())
                .addValue("identity_document", proposal.getIdentityDocument())
                .addValue("email", proposal.getEmail())
                .addValue("name", proposal.getName())
                .addValue("salary", proposal.getSalary())
                .addValue("address", proposal.getAddress());

        jdbcTemplate.update(sql, parameters);
    }

    @Override
    public Optional<Proposal> findByExternalId(UUID externalId) {

        var sql = "SELECT id, external_id, identity_document, email, name, salary, address, created, updated " +
                "FROM proposal " +
                "WHERE external_id = :external_id";

        var parameters = new MapSqlParameterSource()
                .addValue("external_id", externalId);

        return jdbcTemplate.query(sql, parameters, resultSet -> {

            if (resultSet.next()) {
                return Optional.of(new Proposal()
                        .setId(resultSet.getLong("id"))
                        .setExternalId(UUID.fromString(resultSet.getString("external_id")))
                        .setIdentityDocument(resultSet.getString("identity_document"))
                        .setEmail(resultSet.getString("email"))
                        .setName(resultSet.getString("name"))
                        .setSalary(resultSet.getDouble("salary"))
                        .setAddress(resultSet.getString("address"))
                        .setCreated(resultSet.getTimestamp("created").toLocalDateTime())
                        .setUpdated(resultSet.getTimestamp("updated").toLocalDateTime()));
            }

            return Optional.empty();
        });
    }
}
