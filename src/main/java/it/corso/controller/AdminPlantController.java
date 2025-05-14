package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Nursery;
import it.corso.service.NurseryService;




@Controller
@RequestMapping("/admin_plant")
public class AdminPlantController {

    @Autowired
    private NurseryService nurseryService;

    @GetMapping
    public String renderPage(Model model) {
        List<Nursery> plants = nurseryService.getAllNursery();
        model.addAttribute("plants", plants);
        return "admin_plant";
    }

    @GetMapping("/activate")
    public String activate(@RequestParam(required = true) Integer id) {
        nurseryService.activateDisableNursery(id, "activate");
        return "redirect:/admin_plant";
    }

    @GetMapping("/disable")
    public String disable(@RequestParam(required = true) Integer id) {
        nurseryService.activateDisableNursery(id, "disable");
        return "redirect:/admin_plant";
    }
    
    
    
}
