package com.jscomp.zooweb.controller;

import com.jscomp.zooweb.domain.Caretaker;
import com.jscomp.zooweb.repository.CaretakerRepository;
import com.jscomp.zooweb.validation.CaretakerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CaretakerController {

    private CaretakerRepository caretakerRepository;
    private CaretakerValidator caretakerValidator;

    @Autowired
    public CaretakerController(CaretakerRepository caretakerRepository, CaretakerValidator caretakerValidator) {
        this.caretakerRepository = caretakerRepository;
        this.caretakerValidator = caretakerValidator;
    }

    @RequestMapping(value = "/addCaretaker", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String addCaretaker(Model model) {
        model.addAttribute("caretaker", new Caretaker());

        return "/addCaretaker";
    }

    @RequestMapping(value = "/addCaretaker", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    /*@ModelAttribute непосредственно перед параметром в методе - и он будет загружен из модели по имени или по указанному названию.*/
    public String addCaretaker(@ModelAttribute("caretaker") Caretaker caretaker, BindingResult bindingResult) {
        this.caretakerValidator.validate(caretaker, bindingResult);
        if (bindingResult.hasErrors()){
            return "/addCaretaker";
        }

        this.caretakerRepository.addCaretaker(caretaker);

        return "redirect:/";
    }
}
