package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.service.AdminService;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/admin_login")
public class AdminLoginController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping
    public String renderPage(@RequestParam(required = false) String errore, Model model, HttpSession session) {
        if (session.getAttribute("admin") != null) {
            return "redirect:/admin_page";
        }
        model.addAttribute("errore",errore );
        return "admin_login";
    }

    @PostMapping
    public String handleForm(@RequestParam String username, @RequestParam String pword, HttpSession session) {
        String esito = adminService.controlloLogin(username, pword, session);
        if (esito.equals("Incorrect username or password") ) {
            return "redirect:/admin_login?errore=" + esito;
        }
        return "admin_page"; 
    }
    

    
    
}
