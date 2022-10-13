package org.example.core.io;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DefaultResourceLoader.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        Objects.requireNonNull(location,"Resource location mmust not be null");
        if(location.startsWith(CLASSPATH_URL_PREFIX)){
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else{
            try{
                return new UrlResource(new URL(location));
            }catch (MalformedURLException ex){
                return new FileSystemResource(location);
            }
        }
    }
}
