package org.example.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName Resource.java
 * @Description TODO
 * @createTime 2022/10/12
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
