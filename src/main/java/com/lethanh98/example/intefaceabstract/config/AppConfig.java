package com.lethanh98.example.intefaceabstract.config;

import com.lethanh98.example.intefaceabstract.resource.Resource;

import java.util.Properties;

public class AppConfig {
    private Properties properties;

    public AppConfig(Resource resource) {
        try {
            if (resource.exists()) {
                properties = new Properties();
                properties.load(resource.getInputStream());
            }
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    public Properties getProperties() {
        return properties;
    }

}
