package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login-check")
    public String loginCheck(@RequestParam String email, @RequestParam String password, Model model) {
        if (email.contains("@") && password.length() >= 8) {
            return "redirect:/quiz";
        } else {
            model.addAttribute("message", "Invalid email or weak password.");
            return "bad-password";
        }
    }
}
