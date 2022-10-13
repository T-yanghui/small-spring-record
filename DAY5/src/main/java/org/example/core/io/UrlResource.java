package org.example.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName UrlResource.java
 * @Description TODO
 * @createTime 2022/10/12
 */
public class UrlResource implements Resource{
    private final URL url;

    public UrlResource(URL url) {
        Objects.requireNonNull(url,"URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection conn=url.openConnection();
        try{
            return conn.getInputStream();
        }catch (IOException ex){
            if(conn instanceof HttpURLConnection){
                ((HttpURLConnection) conn).disconnect();
            }
            throw ex;
        }
    }
}
