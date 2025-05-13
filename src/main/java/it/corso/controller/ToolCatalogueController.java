package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Accessory;
import it.corso.service.AccessoryService;



@Controller
@RequestMapping("/tool_catalogue")
public class ToolCatalogueController {
    
    @Autowired
    private AccessoryService accessoryService;

    @GetMapping
    public String renderPage(Model model) {
        List<Accessory> tools = accessoryService.getAllAccessory();
        model.addAttribute("tools",tools);
        return "tool_catalogue";
    }
    
}
