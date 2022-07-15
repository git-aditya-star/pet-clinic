package aditya.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","index","index.html"})  //used for http request
    public String index(){
        return "index"; //maps to index.html
    }
}
