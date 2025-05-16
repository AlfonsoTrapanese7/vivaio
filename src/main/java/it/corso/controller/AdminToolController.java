package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Accessory;
import it.corso.service.AccessoryService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Category;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/admin_tool")
public class AdminToolController {

    @Autowired
    private AccessoryService accessoryService;

    @GetMapping
    public String renderPage(Model model) {
        Accessory accessory = new Accessory();
        model.addAttribute("accessory", accessory);
        List<Accessory> tools = accessoryService.getAllAccessory();
        List<Category> categories = accessoryService.getAllCategory();
        model.addAttribute("tools", tools);
        model.addAttribute("categories", categories);
        return "admin_tool";
    }

    @GetMapping("/activate")
    public String activateTool(@RequestParam Integer id) {
        accessoryService.activateDisableAccessory(id, "activate");
        return "redirect:/admin_tool";
    }

    @GetMapping("/disable")
    public String disableTool(@RequestParam Integer id) {
        accessoryService.activateDisableAccessory(id, "disable");
        return "redirect:/admin_tool";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:/";
    }

    @PostMapping
    public String accessoryForm(@Valid @ModelAttribute Accessory accesory, BindingResult result, @RequestParam MultipartFile photography, Model model) {
        if(result.hasErrors()){
        Accessory accessoryf = new Accessory();
        model.addAttribute("accesory", accessoryf);
        List<Accessory> tools = accessoryService.getAllAccessory();
        List<Category> categories = accessoryService.getAllCategory();
        model.addAttribute("tools", tools);
        model.addAttribute("categories", categories);
            return "admin_tool";
        }
        accessoryService.saveAccessoryAndPhoto(accesory, photography);
        return "redirect:/admin_tool";
    }
    
}
