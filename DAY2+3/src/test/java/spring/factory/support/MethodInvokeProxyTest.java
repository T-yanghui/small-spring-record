package spring.factory.support;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName MethodInvokeProxyTest.java
 * @Description TODO
 * @createTime 2022/10/11
 */
public class MethodInvokeProxyTest {
    private static Callback callback1=new MethodInterceptor(){

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("before callback...");
            Object res=methodProxy.invokeSuper(o,objects);
            System.out.println("after callback...");
            return res;
        }
    };
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallbacks(new Callback[]{callback1,NoOp.INSTANCE});
        enhancer.setCallbackFilter(new TargetMethodFileter());
        Dao dao=(Dao) enhancer.create();
        dao.method1();
        dao.method2();
    }

}
class Dao{
    public void method1(){
        System.out.println("method1 query....");
    }
    public void method2(){
        method1();
        System.out.println("method2 insert...");
    }
}
class TargetMethodFileter implements CallbackFilter{

    @Override
    public int accept(Method method) {
        if("method1".equals(method.getName())){
            return 0;
        }else{
            return 1;
        }
    }
}
