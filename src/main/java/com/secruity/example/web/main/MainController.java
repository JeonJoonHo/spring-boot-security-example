package com.secruity.example.web.main;

import com.secruity.example.web.user.CurrentUser;
import com.secruity.example.web.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String index(@CurrentUser User user, Model model) {
        model.addAttribute("foo", "bar");
        model.addAttribute("user", user);

        return "index";
    }
}
