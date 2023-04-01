package org.example.aop.aspectj;

import org.aopalliance.aop.Advice;
import org.example.aop.Pointcut;
import org.example.aop.PointcutAdvisor;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AspectJExpressionPointcutAdvisor.java
 * @Description TODO
 * @createTime 2022/11/27
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    private AspectJExpressionPointcut pointcut;
    private Advice advice;
    private String expression;

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            this.pointcut = new AspectJExpressionPointcut(this.expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
