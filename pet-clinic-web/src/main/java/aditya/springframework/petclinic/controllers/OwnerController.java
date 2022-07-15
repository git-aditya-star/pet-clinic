package aditya.springframework.petclinic.controllers;

import aditya.springframework.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")  //since every request has owners as start point we can use here so it automatically get added to all the subsequent request mappings
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/index","/index.html"})
    public  String getListOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());  //create a model with all the objects of Owner using the findAll method
        return "owners/index";
    }
}
