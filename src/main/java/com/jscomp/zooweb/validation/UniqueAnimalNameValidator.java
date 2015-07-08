package com.jscomp.zooweb.validation;

import com.jscomp.zooweb.repository.AnimalRepository;
import com.jscomp.zooweb.validation.annotation.UniqueAnimalName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueAnimalNameValidator implements ConstraintValidator<UniqueAnimalName, String> {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public void initialize(UniqueAnimalName uniqueAnimalName) {

    }

    /**
     * Validate if exists object in database with name == given parameter animalName.
     * Return true (valid) if not exists and false (not valid) if exists.
     *
     * @param animalName       in fact Animal object for validation
     * @param cxt        error container
     * */
    @Override
    public boolean isValid(String animalName, ConstraintValidatorContext cxt) {
        return animalRepository.getAnimalByName(animalName) == null;
    }
}

