package org.example.core.io;

import org.example.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ClassPathResource.java
 * @Description TODO
 * @createTime 2022/10/12
 */
public class ClassPathResource implements Resource {
    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Objects.requireNonNull(path, "Path must not be null...");
        this.path = path;
        this.classLoader = (classLoader == null ? ClassUtils.getDefaultClassLoader() : classLoader);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (null == is) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exists");
        }
        return is;
    }
}
