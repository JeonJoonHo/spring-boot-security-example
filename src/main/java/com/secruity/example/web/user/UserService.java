package com.secruity.example.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createNewUser(SignUpForm signUpForm) {
        return save(signUpForm);
    }

    private User save(SignUpForm signUpForm) {
        User user = User.builder()
                .nickname(signUpForm.getNickname())
                .email(signUpForm.getEmail())
                .password(signUpForm.getPassword())
                .build();

        return userRepository.save(user);
    }
}
