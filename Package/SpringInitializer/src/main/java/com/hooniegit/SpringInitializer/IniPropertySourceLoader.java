package com.hooniegit.SpringInitializer;

import org.ini4j.Ini;
import org.ini4j.Profile;

import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * Ini Property Source Loader - Based on ini4j
 */
public class IniPropertySourceLoader implements PropertySourceFactory {

    /**
     * [Override] Create Property Source for Application.yml
     * @param name
     * @param resource
     * @return
     */
    @Override
    public PropertySource createPropertySource(String name, EncodedResource resource) {
        Properties props = new Properties();

        // Based on Input Stream
        try (InputStream input = resource.getInputStream()) {
            Ini ini = new Ini(input);

            // Read Keys & Set Properties
            for (String sectionName : ini.keySet()) {
                Profile.Section section = ini.get(sectionName);
                for (String optionKey : section.keySet()) {
                    String fullKey = sectionName + "." + optionKey;
                    props.setProperty(fullKey, section.get(optionKey));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new PropertiesPropertySource(name, props);
    }
}
