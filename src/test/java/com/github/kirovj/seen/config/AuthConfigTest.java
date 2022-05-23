package com.github.kirovj.seen.config;


import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author : kirovj
 * @date : 2022/5/23
 */
@Component
public class AuthConfigTest implements CommandLineRunner {

    @Autowired
    private AuthConfig config;

    @Override
    public void run(String... args) throws Exception {
        Assert.assertTrue(config.check("guest", "guest"));
    }
}