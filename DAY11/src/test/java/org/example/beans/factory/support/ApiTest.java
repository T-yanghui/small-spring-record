package org.example.beans.factory.support;

import org.example.aop.AdvisedSupport;
import org.example.aop.TargetSource;
import org.example.aop.aspectj.AspectJExpressionPointcut;
import org.example.aop.framework.Cglib2AopProxy;
import org.example.aop.framework.JdkDynamicAopProxy;
import org.example.beans.factory.support.beans.IUserService;
import org.example.beans.factory.support.beans.UserService;
import org.example.beans.factory.support.beans.UserServiceIntercepter;
import org.example.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public class ApiTest {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @Before
    public void setUp() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        classPathXmlApplicationContext.registerShutdownHook();
    }

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* org.example.beans.factory.support.beans.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("register", String.class);

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
        String str = null;
        System.out.println(str instanceof String);
        System.out.println(str.equals("null"));
    }

    @Test
    public void test_dynamic() {
        IUserService userService = new UserService();
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* org.example.beans.factory.support.beans.IUserService.*(..))"));
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceIntercepter());

        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();

        System.out.println(proxy_jdk.queryUserInfo());
        System.out.println(proxy_jdk.register("Tessa"));
    }

    @Test
    public void test_solution() {
        Solution solution = new Solution();
        System.out.println(solution.shortestCommonSupersequence("abac", "cab"));
    }
}

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int length1 = str1.length(), length2 = str2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = length1 - 1, j = length2 - 1;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                sb.append(str2.charAt(j--));
            } else if (j == -1) {
                sb.append(str1.charAt(i--));
            } else {
                if (str1.charAt(i) == str2.charAt(j)){
                    sb.append(str1.charAt(i));
                    i--;
                    j--;
                }else if(dp[i][j]==dp[i+1][j]){
                    sb.append(str1.charAt(i--));
                }else{
                    sb.append(str2.charAt(j--));
                }
            }
        }
        return sb.reverse().toString();
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

