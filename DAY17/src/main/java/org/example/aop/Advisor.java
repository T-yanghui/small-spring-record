package org.example.aop;

import org.aopalliance.aop.Advice;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName Advisor.java
 * @Description TODO
 * @createTime 2022/11/27
 */
public interface Advisor {
    Advice getAdvice();
}
