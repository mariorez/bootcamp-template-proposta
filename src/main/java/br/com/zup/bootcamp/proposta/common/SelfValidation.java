package br.com.zup.bootcamp.proposta.common;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import java.util.Set;

public interface SelfValidation {

    default void selfValidate() {
        var validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<SelfValidation>> violations = validator.validate(this);
        if (!violations.isEmpty()) throw new ConstraintViolationException(violations);
    }
}
