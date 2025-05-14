package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Nursery;
import it.corso.service.NurseryService;


@Controller
@RequestMapping("/plant_details")
public class PlantDetailsController {

    @Autowired
    private NurseryService nurseryService;

    @GetMapping
    public String renderPage(@RequestParam(required = true) Integer id, Model model) {
        Nursery plant = nurseryService.getPlant(id);
        model.addAttribute("plant", plant);
        return "plant_details";
    }
    
}
