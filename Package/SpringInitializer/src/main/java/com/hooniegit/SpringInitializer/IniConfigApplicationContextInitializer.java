package com.hooniegit.SpringInitializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * Initialize Spring Application with Config.ini
 * - Create Property Source
 * - Set Spring Properties
 */
public class IniConfigApplicationContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    /**
     * [Override] Initialization
     * @param context the application to configure
     */
    @Override
    public void initialize(ConfigurableApplicationContext context) {
        try {
            // Default Path is Windows C:\\Config\\config.ini
            // Run Command : $ java -Dconfig.path=<path/to/ini> -jar <ApplicationName>.jar
            String path = System.getProperty("config.path", "C:/Config/config.ini");
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

