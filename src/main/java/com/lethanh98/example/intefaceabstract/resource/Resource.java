package com.lethanh98.example.intefaceabstract.resource;


import java.io.InputStream;

public interface Resource extends InputStreamSource {
    InputStream getInputStream();

    boolean exists();
    String body();

    default boolean isReadable() {
        return exists();
    }

    default boolean isOpen() {
        return false;
    }

    default boolean isFile() {
        return false;
    }
}
