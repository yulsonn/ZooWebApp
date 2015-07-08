package com.jscomp.zooweb.controller;

import com.jscomp.zooweb.domain.Animal;
import com.jscomp.zooweb.domain.Cage;
import com.jscomp.zooweb.domain.Caretaker;
import com.jscomp.zooweb.repository.AnimalRepository;
import com.jscomp.zooweb.repository.CageRepository;
import com.jscomp.zooweb.repository.CaretakerRepository;
import com.jscomp.zooweb.validation.AnimalChangeValidator;
import com.jscomp.zooweb.validation.AnimalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AnimalController {

    private AnimalRepository animalRepository;
    private CaretakerRepository caretakerRepository;
    private CageRepository cageRepository;

    private AnimalValidator animalValidator;
    private AnimalChangeValidator animalChangeValidator;

    @Autowired
    public AnimalController(CaretakerRepository caretakerRepository, AnimalRepository animalRepository,
                            CageRepository cageRepository, AnimalValidator animalValidator, AnimalChangeValidator animalChangeValidator) {
        this.caretakerRepository = caretakerRepository;
        this.animalRepository = animalRepository;
        this.cageRepository = cageRepository;
        this.animalValidator = animalValidator;
        this.animalChangeValidator = animalChangeValidator;
    }

    @RequestMapping(value = "/addAnimal", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String addAnimal(Model model) {
        model.addAttribute("animal", new Animal());

        List<Cage> cages = this.cageRepository.getCageList();
        model.addAttribute("cages", cages);

        List<Caretaker> caretakers = this.caretakerRepository.getCaretakerList();
        model.addAttribute("caretakers", caretakers);

        return "addAnimal";
    }

    @RequestMapping(value = "/addAnimal", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String addAnimal(Model model, @ModelAttribute("animal") @Valid Animal animal, BindingResult bindingResult) {
        this.animalValidator.validate(animal, bindingResult);

        if (bindingResult.hasErrors()){

            model.addAttribute("cages", this.cageRepository.getCageList());
            model.addAttribute("caretakers", this.caretakerRepository.getCaretakerList());

            return "addAnimal";
        }

        this.animalRepository.addAnimal(animal);

        return "redirect:/";
    }

    @RequestMapping(value = "/deleteAnimal/{id}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String deleteAnimal(@PathVariable Integer id) {
        this.animalRepository.deleteAnimal(id);

        return "redirect:/";
    }

    @RequestMapping(value = "/updateAnimal/{id}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String editAnimal(@PathVariable Integer id, Model model) {
        Animal animal = this.animalRepository.getAnimal(id);
        model.addAttribute("editAnimal", animal);
        model.addAttribute("cages", this.cageRepository.getCageList());
        model.addAttribute("caretakers", this.caretakerRepository.getCaretakerList());

        return "/editAnimal";
    }

    @RequestMapping(value = "/updateAnimal/{id}", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String editAnimal(Model model, @ModelAttribute("editAnimal")  Animal animal, BindingResult bindingResult) {
        this.animalValidator.validate(animal, bindingResult);
        this.animalChangeValidator.validate(animal, bindingResult);


        if (bindingResult.hasErrors()){

            model.addAttribute("cages", this.cageRepository.getCageList());
            model.addAttribute("caretakers", this.caretakerRepository.getCaretakerList());

            return "/editAnimal";
        }

        this.animalRepository.updateAnimal(animal);

        return "redirect:/";
    }


}
