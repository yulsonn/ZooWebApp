package com.jscomp.zooweb.validation;

import com.jscomp.zooweb.domain.Animal;
import com.jscomp.zooweb.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AnimalChangeValidator implements Validator {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return Animal.class.isAssignableFrom(aClass);
    }

    /**
     * Used when
     * Validates the name of given object for unique.
     * Find the object in database, which name equals with the given object's name.
     * Check if there is the same object - ok, if it is not - add an error to error container.
     *
     * @param obj       in fact Animal object for validation
     * @param errors    error container
     * */
    @Override
    public void validate(Object obj, Errors errors) {

        if (obj != null) {

            Animal animal = (Animal) obj;
            int animalId = animal.getId();
            String animalName = animal.getName();

            Animal compareAnimal = animalRepository.getAnimalByName(animalName);

            if (compareAnimal != null) {
                int compareAnimalId = compareAnimal.getId();
                if (animalId != compareAnimalId) {
                    errors.rejectValue("name", "not.unique.name");
                }
            }
        }
    }
}
