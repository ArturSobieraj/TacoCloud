package com.tc.tacocloud.security;

import com.tc.tacocloud.model.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return User.builder()
                .username(this.username)
                .password(passwordEncoder.encode(this.password))
                .fullname(this.fullname)
                .street(this.street)
                .city(this.city)
                .state(this.state)
                .zip(this.zip)
                .phoneNumber(this.phone)
                .build();
    }
}
