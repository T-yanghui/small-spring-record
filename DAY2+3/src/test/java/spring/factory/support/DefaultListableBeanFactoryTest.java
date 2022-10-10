package spring.factory.support;


import org.junit.Before;
import org.junit.Test;
import spring.factory.config.BeanDefinition;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DefaultListableBeanFactoryTest.java
 * @Description TODO
 * @createTime 2022/10/09
 */
public class DefaultListableBeanFactoryTest {
    DefaultListableBeanFactory beanFactory;
    @Before
    public void setup(){
        beanFactory=new DefaultListableBeanFactory();
        beanFactory.setInstantiationStratege(new SimpleInstantiationStratege());
        beanFactory.registerBeanDefinition("service",new BeanDefinition(Service.class));
    }
    @Test
    public void factoryTest(){
        Service service= (Service) beanFactory.getBean("service","A");
        for(int i=0;i<10;i++) {
            service.doService();
        }
    }
}
class Service {
    String serviceName;
    public Service(String serviceName){
        this.serviceName=serviceName;
    }
    public void doService(){
        System.out.println(this.serviceName+" do Service...");
    }
}