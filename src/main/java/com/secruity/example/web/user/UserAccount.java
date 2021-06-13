package com.secruity.example.web.user;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Getter
public class UserAccount extends User {

    private com.secruity.example.web.user.User user;

    public UserAccount(com.secruity.example.web.user.User user) {
        super(user.getNickname(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        this.user = user;
    }
}
