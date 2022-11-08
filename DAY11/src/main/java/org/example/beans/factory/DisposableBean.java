package org.example.beans.factory;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DisposableBean.java
 * @Description TODO Bean销毁时执行
 * @createTime 2022/10/23
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
