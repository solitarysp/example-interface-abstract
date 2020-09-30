package com.lethanh98.example.intefaceabstract.resource.impl;

import com.lethanh98.example.intefaceabstract.resource.Resource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class ResourceFile implements Resource {
    String body = null;
    byte buf[];

    public ResourceFile(String path) {
        try {
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            buf = baos.toByteArray();
            //creating an InputStreamReader object
            InputStreamReader isReader = new InputStreamReader(getInputStream());
            //Creating a BufferedReader object
            BufferedReader reader = new BufferedReader(isReader);
            StringBuffer sb = new StringBuffer();
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            this.body = sb.toString();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    @Override
    public InputStream getInputStream() {
        return new ByteArrayInputStream(buf);
    }

    @Override
    public boolean exists() {
        if (Objects.nonNull(buf)) {
            return true;
        }
        return false;
    }

    @Override
    public String body() {
        return body;

    }

    @Override
    public boolean isReadable() {
        if (Objects.nonNull(buf)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isOpen() {
        if (Objects.nonNull(buf)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }
}
