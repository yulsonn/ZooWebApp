package com.jscomp.zooweb.validation.annotation;

import com.jscomp.zooweb.validation.UniqueAnimalNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {UniqueAnimalNameValidator.class})
public @interface UniqueAnimalName {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
