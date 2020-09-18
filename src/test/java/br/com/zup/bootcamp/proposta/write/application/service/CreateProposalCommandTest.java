package br.com.zup.bootcamp.proposta.write.application.service;

import helper.TestHelper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Tag("unit")
class CreateProposalCommandTest extends TestHelper {

    @ParameterizedTest
    @MethodSource("invalidDataProvider")
    void GIVEN_InvalidData_MUST_ThrowsException(String identityDocument,
                                                String email,
                                                String name,
                                                Double salary,
                                                String address,
                                                String errorField,
                                                String errorMessage) {

        // when
        var constraintViolationException = assertThrows(ConstraintViolationException.class, () -> {
            new CreateProposalCommand(identityDocument, email, name, salary, address);
        });

        // then
        var constraintViolations = constraintViolationException.getConstraintViolations();
        assertThat(constraintViolations)
                .extracting("propertyPath.currentLeafNode.name", "interpolatedMessage")
                .contains(tuple(errorField, errorMessage));
    }

    private static Stream<Arguments> invalidDataProvider() {

        var validDocument = faker.number().digits(11);
        var validEmail = faker.internet().emailAddress();
        var validName = faker.dragonBall().character();
        var validSalary = (Double) faker.number().randomDouble(2, 3, 6);
        var validAddress = faker.address().fullAddress();

        return Stream.of(
                arguments(null, validEmail, validName, validSalary, validAddress, "identityDocument", "must not be blank"),
                arguments("", validEmail, validName, validSalary, validAddress, "identityDocument", "must not be blank"),
                arguments("  ", validEmail, validName, validSalary, validAddress, "identityDocument", "must not be blank"),
                arguments(validDocument, null, validName, validSalary, validAddress, "email", "must not be blank"),
                arguments(validDocument, "", validName, validSalary, validAddress, "email", "must not be blank"),
                arguments(validDocument, "  ", validName, validSalary, validAddress, "email", "must not be blank"),
                arguments(validDocument, "xyz", validName, validSalary, validAddress, "email", "must be a well-formed email address")
        );
    }
}