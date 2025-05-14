package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/admin_page")
public class AdminPageController {

    @GetMapping
    public String renderPage() {
        return "admin_page";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");;
        return "redirect:/";
    }
}
