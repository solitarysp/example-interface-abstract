package com.lethanh98.example.intefaceabstract;

import com.lethanh98.example.intefaceabstract.config.AppConfig;
import com.lethanh98.example.intefaceabstract.resource.Resource;
import com.lethanh98.example.intefaceabstract.resource.impl.ResourceFile;

public class Main {
    private static final String WORKING_DIR = System.getProperty("user.dir");
    public static void main(String[] args) {
        Resource resourceUrl = new ResourceFile(WORKING_DIR+"/config/fileconfig.properties");
        AppConfig appConfig = new AppConfig(resourceUrl);
        System.out.println(appConfig.getProperties().getProperty("test"));

    }
}
