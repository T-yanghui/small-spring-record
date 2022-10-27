package org.example.core.io;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ResourceLoader.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
