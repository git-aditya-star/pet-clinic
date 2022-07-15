package aditya.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")  //since every request has owners as start point we can use here so it automatically get added to all the subsequent request mappings
@Controller
public class OwnerController {

    @RequestMapping({"","/index","/index.html"})
    public  String getListOwners(){
        return "owners/index";
    }
}
