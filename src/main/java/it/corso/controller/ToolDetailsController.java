package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Accessory;
import it.corso.service.AccessoryService;


@Controller
@RequestMapping("/tool_details")
public class ToolDetailsController {

    @Autowired
    private AccessoryService accessoryService;

    @GetMapping
    public String renderPage(@RequestParam(required = true) Integer id, Model model) {
        Accessory tool = accessoryService.getAccessoryById(id);
        model.addAttribute("tool", tool);
        return "tool_details";
    }
    
}
