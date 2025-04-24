package com.hooniegit.SpringInitializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

public class IniConfigApplicationContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        try {
            String path = System.getProperty("config.path", "/Users/a1234/git/Project/SpringInitializer/Test/config.ini");
            Resource resource = new FileSystemResource(path);
            if (!resource.exists()) {
                throw new IllegalArgumentException("Config file not found: " + path);
            }
            EncodedResource encodedResource = new EncodedResource(resource);
            PropertySource<?> iniPropertySource =
                    new IniPropertySourceLoader().createPropertySource("custom-ini", encodedResource);
            context.getEnvironment().getPropertySources().addFirst(iniPropertySource);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.ini", e);
        }
    }
}

