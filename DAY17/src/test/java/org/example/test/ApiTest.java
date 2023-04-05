package org.example.test;

import lombok.*;
import org.example.beans.BeansException;
import org.example.beans.factory.config.BeanPostProcessor;
import org.example.context.support.ClassPathXmlApplicationContext;
import org.example.test.bean.IUserService;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description TODO
 * @createTime 2023/03/25
 */
public class ApiTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService.queryUserInfo());
    }

    @Test
    public void test2() {
        Employee employee = new Employee("debugger", "Test", new Employee.EID(123L,null));
        Optional<Employee> optionalEmployee = Optional.ofNullable(employee);
        Long eID = optionalEmployee.map(Employee::getEid)
                .map(Employee.EID::getID).orElseThrow(()->new NullPointerException("空指针"));
        System.out.println(eID);
    }

}

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
class Employee {
    final String name;
    @NonNull
    String department;
    EID eid;

    @Setter
    @Getter
    @AllArgsConstructor
    static class EID {
        Long ID;
        String profile;
    }
}
