package org.example.stereotype;

import java.lang.annotation.*;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName Component.java
 * @Description TODO
 * @createTime 2023/03/24
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}
