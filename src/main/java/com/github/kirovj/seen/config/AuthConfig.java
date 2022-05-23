package com.github.kirovj.seen.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "auth")
public class AuthConfig {

    private String username;

    private String password;

    public boolean check(String name, String pass) {
        return name.equals(username) && pass.equals(password);
    }
}
