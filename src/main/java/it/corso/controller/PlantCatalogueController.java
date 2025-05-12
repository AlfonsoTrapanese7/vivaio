package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
@RequestMapping("/plant_catalogue")
public class PlantCatalogueController {

    @GetMapping
    public String renderPage() {
        return "plant_catalogue";
    }
    
}
