package com.lethanh98.example.intefaceabstract.resource.impl;

import com.lethanh98.example.intefaceabstract.resource.Resource;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class ResourceUrl implements Resource {
    InputStream inputStream;
    String body = null;

    public ResourceUrl(String path) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(path);
            HttpResponse response = client.execute(request);
            // Get the response
            inputStream = response.getEntity().getContent();

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
            e.printStackTrace();
        }
    }

    @Override
    public InputStream getInputStream() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return new ByteArrayInputStream(baos.toByteArray());
        } catch (Exception inputStream) {
            System.out.println("Error getInputStream");
        }
        return null;
    }

    @Override
    public boolean exists() {
        if (Objects.nonNull(inputStream)) {
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
        if (Objects.nonNull(inputStream)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isOpen() {
        if (Objects.nonNull(inputStream)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFile() {
        return false;
    }
}
