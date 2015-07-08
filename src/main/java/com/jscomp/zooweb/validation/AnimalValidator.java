package com.jscomp.zooweb.validation;

import com.jscomp.zooweb.domain.Animal;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AnimalValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Animal.class.isAssignableFrom(aClass);
    }

    /**
     * Validate that all required fields are filled.
     *
     * @param obj       in fact Animal object for validation
     * @param errors    error container
     * */
    @Override
    public void validate(Object obj, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "required.type");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "required.age");
    }
}
