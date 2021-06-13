package com.secruity.example.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public String signUp(SignUpForm signUpForm, RedirectAttributes redirectAttributes) {
        User newUser = userService.createNewUser(signUpForm);

        redirectAttributes.addFlashAttribute("message", newUser.getNickname() + "님 환영합니다.");

        userService.login(newUser);

        return "redirect:/";
    }

    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute(new SignUpForm());

        return "users/sign-up";
    }
}
