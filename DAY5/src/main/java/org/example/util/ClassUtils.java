package org.example.util;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ClassUtils.java
 * @Description TODO
 * @createTime 2022/10/12
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl=null;
        try {
            cl=Thread.currentThread().getContextClassLoader();
        }catch (Throwable ex){

        }
        if(null==cl){
            cl=ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
