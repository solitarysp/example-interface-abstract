package com.lethanh98.example.intefaceabstract.resource;

import java.io.File;
import java.io.IOException;

public interface FileSource {
    File getFile() throws IOException;
}
