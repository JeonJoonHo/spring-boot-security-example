package com.secruity.example.web.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("foo", "bar");

        return "index";
    }
}
