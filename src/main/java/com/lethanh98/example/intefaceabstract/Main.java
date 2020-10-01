package com.lethanh98.example.intefaceabstract;

import com.lethanh98.example.intefaceabstract.config.AppConfig;
import com.lethanh98.example.intefaceabstract.resource.Resource;
import com.lethanh98.example.intefaceabstract.resource.impl.ResourceFile;
import com.lethanh98.example.intefaceabstract.resource.impl.ResourceUrl;

public class Main {
    private static final String WORKING_DIR = System.getProperty("user.dir");
    public static void main(String[] args) {
        Resource resourceUrl = new ResourceUrl("https://raw.githubusercontent.com/solitarysp/example-interface-abstract/master/config/fileconfig.properties");
        Resource resourceFile = new ResourceFile(WORKING_DIR + "/config/fileconfig.properties");
        AppConfig appConfig = new AppConfig(resourceFile);
        System.out.println(appConfig.getProperties().getProperty("test"));

    }
}
