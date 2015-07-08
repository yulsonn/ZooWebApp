package com.jscomp.zooweb.controller;

import com.jscomp.zooweb.domain.Animal;
import com.jscomp.zooweb.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ZooController {

    private AnimalRepository animalRepository;


    @Autowired
    public ZooController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String getAnimals(Model model){
        List<Animal> animals = this.animalRepository.getAnimalList();
        model.addAttribute("animals", animals);

        return "/index";
    }


}
