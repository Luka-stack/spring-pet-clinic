package com.nisshoku.springpetsclinic.controllers;

import com.nisshoku.springpetsclinic.model.Pet;
import com.nisshoku.springpetsclinic.model.Visit;
import com.nisshoku.springpetsclinic.services.PetService;
import com.nisshoku.springpetsclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(final VisitService visitService, final PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void dataBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");

        webDataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalAccessError {
                setValue(LocalDate.parse(text));
            }
        });
    }

    /*
        Called before each and every @RequestMapping has two goals:
        - Make sure we always have fresh data
        - Since we do not use session scope, make sure that Pet object always has an id
     */
    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Map<String, Object> model) {
        Pet pet = petService.findById(petId);
        Visit visit = new Visit();

        model.put("pet", pet);
        pet.getVisits().add(visit);
        visit.setPet(pet);

        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable Long petId, Map<String, Object> model) {
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("/owners/*/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        }
        else {
            visitService.save(visit);

            return "redirect:/owners/{ownerId}";
        }
    }
}
