package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Nursery;
import it.corso.service.NurseryService;

import org.springframework.web.bind.annotation.GetMapping;





@Controller
@RequestMapping("/plant_catalogue")
public class PlantCatalogueController {

    @Autowired
    private NurseryService nurseryService;

    @GetMapping
    public String renderPage(Model model) {
        List<Nursery> nurseryPlants = nurseryService.getAllNursery();
        model.addAttribute("nurseryPlants", nurseryPlants);
        return "plant_catalogue";
    }
    
}
