package it.corso.service;

import jakarta.servlet.http.HttpSession;

public interface AdminService {
    String controlloLogin(String username, String pword, HttpSession session);
}
