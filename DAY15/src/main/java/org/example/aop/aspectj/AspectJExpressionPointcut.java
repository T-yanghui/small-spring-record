package org.example.aop.aspectj;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.example.aop.ClassFilter;
import org.example.aop.MethodMatcher;
import org.example.aop.Pointcut;

import java.lang.reflect.Method;
import java.util.HashSet;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AspectJExpressionPointcut.java
 * @Description Use the AspectJ weaver to evaluate a pointcut expression
 * @createTime 2022/11/07
 */
public class AspectJExpressionPointcut implements ClassFilter, MethodMatcher, Pointcut {
    private final static HashSet<PointcutPrimitive>  SUPPORTED_PRIMITIVES=new HashSet<>();
    static {
        SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
    }
    private final PointcutExpression pointcutExpression;

    public AspectJExpressionPointcut(String expression) {
        PointcutParser pointcutParser=PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORTED_PRIMITIVES,this.getClass().getClassLoader());
        pointcutExpression=pointcutParser.parsePointcutExpression(expression);
    }

    @Override
    public boolean matches(Class<?> clazz) {
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    @Override
    public boolean matches(Method method, Class<?> clazz) {
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
