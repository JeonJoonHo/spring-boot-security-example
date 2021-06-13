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

    private final UserRepository userRepository;

    @PostMapping("/sign-up")
    public String signUp(SignUpForm signUpForm, RedirectAttributes redirectAttributes) {
        User user = User.builder()
                .nickname(signUpForm.getNickname())
                .email(signUpForm.getEmail())
                .password(signUpForm.getPassword())
                .build();

        User newUser = userRepository.save(user);

        redirectAttributes.addFlashAttribute("message", newUser.getNickname() + "님 환영합니다.");

        return "redirect:/";
    }

    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute(new SignUpForm());

        return "users/sign-up";
    }
}
