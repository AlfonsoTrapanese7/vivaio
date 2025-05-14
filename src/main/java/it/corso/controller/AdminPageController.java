package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/admin_page")
public class AdminPageController {

    @GetMapping
    public String renderPage() {
        return "admin_page";
    }
    

}
