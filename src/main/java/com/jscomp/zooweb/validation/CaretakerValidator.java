package com.jscomp.zooweb.validation;

import com.jscomp.zooweb.domain.Caretaker;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CaretakerValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Caretaker.class.isAssignableFrom(aClass);
    }

    /**
     * Validate that all required fields are filled.
     *
     * @param obj       in fact Caretaker object for validation
     * @param errors    error container
     * */
    @Override
    public void validate(Object obj, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "required.lastname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "required.firstname");
    }
}
