package org.example.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName FileSystemResource.java
 * @Description TODO
 * @createTime 2022/10/12
 */
public class FileSystemResource implements Resource {
    private final String path;
    private final File file;

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }
}
