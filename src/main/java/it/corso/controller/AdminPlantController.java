package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Location;
import it.corso.model.Nursery;
import it.corso.model.Type;
import it.corso.service.NurseryService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;






@Controller
@RequestMapping("/admin_plant")
public class AdminPlantController {

    @Autowired
    private NurseryService nurseryService;

    @GetMapping
    public String renderPage(Model model) {
        Nursery nursery = new Nursery();
        model.addAttribute("nursery", nursery);
        List<Nursery> plants = nurseryService.getAllNursery();
        List<Type> types = nurseryService.getAllType();
        List<Location> locations = nurseryService.getAllLocation();
        model.addAttribute("types", types);
        model.addAttribute("locations", locations);
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

    @GetMapping("/delete")
    public String delete(@RequestParam(required = true) Integer id) {
        nurseryService.deleteNurseryById(id);
        return "redirect:/admin_plant";
    }
    
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:/";
    }

    @PostMapping
    public String handleForm(@Valid @ModelAttribute Nursery nursery, BindingResult result, @RequestParam MultipartFile photography, Model model) {
        if(result.hasErrors()) {
            
            List<Nursery> plants = nurseryService.getAllNursery();
            List<Type> types = nurseryService.getAllType();
            List<Location> locations = nurseryService.getAllLocation();
            model.addAttribute("types", types);
            model.addAttribute("locations", locations);
            model.addAttribute("plants", plants);
            return "admin_plant";
        }
        nurseryService.saveNurseryAndPhoto(nursery, photography);
        return "redirect:/admin_plant";
    }
    
    
    
}
