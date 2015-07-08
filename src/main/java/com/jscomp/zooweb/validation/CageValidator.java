package com.jscomp.zooweb.validation;

import com.jscomp.zooweb.domain.Cage;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class CageValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return Cage.class.isAssignableFrom(aClass);
    }

    /**
     * Validate that all required fields are filled.
     *
     * @param obj       in fact Cage object for validation
     * @param errors    error container
     * */
    @Override
    public void validate(Object obj, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "required.number");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.description");
    }
}
