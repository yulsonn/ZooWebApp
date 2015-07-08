package com.jscomp.zooweb.controller;

import com.jscomp.zooweb.domain.Cage;
import com.jscomp.zooweb.repository.CageRepository;
import com.jscomp.zooweb.validation.CageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CageController {

    private CageRepository cageRepository;
    private CageValidator cageValidator;

    @Autowired
    public CageController(CageRepository cageRepository, CageValidator cageValidator) {
        this.cageRepository = cageRepository;
        this.cageValidator = cageValidator;
    }

    @RequestMapping(value = "/addCage", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String addCage(Model model) {
        model.addAttribute("cage", new Cage());

        return "/addCage";
    }

    @RequestMapping(value = "/addCage", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    /*@ModelAttribute непосредственно перед параметром в методе - он будет загружен из модели по имени или по указанному названию.*/
    public String addCage(@ModelAttribute("cage") @Valid Cage cage, BindingResult bindingResult) {
        this.cageValidator.validate(cage, bindingResult);

        if (bindingResult.hasErrors()){
            return "/addCage";
        }

        this.cageRepository.addCage(cage);

        return "redirect:/";
    }
}
