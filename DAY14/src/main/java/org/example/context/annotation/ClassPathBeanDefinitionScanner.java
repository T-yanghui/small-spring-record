package org.example.context.annotation;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.Strings;
import org.example.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.example.beans.factory.config.BeanDefinition;
import org.example.beans.factory.support.BeanDefinitionRegistry;
import org.example.stereotype.Component;

import java.util.Set;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ClassPathBeanDefinitionScanner.java
 * @Description TODO
 * @createTime 2023/03/24
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {
    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidate = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidate) {
                String beanScope = resolveBeanScope(beanDefinition);
                if (!Strings.isNullOrEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
        //注册处理注解@Autowire和@Value的 AutoWiredAnnotationBeanPostProcessor
        registry.registerBeanDefinition("AutowiredAnnotationBeanPostProcessor",new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));
    }
    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        return (scope == null) ? StrUtil.EMPTY : scope.value();
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> clazz = beanDefinition.getBeanClass();
        Component component = clazz.getAnnotation(Component.class);
        String value = component.value();
        return (Strings.isNullOrEmpty(value)) ?
                StrUtil.lowerFirst(clazz.getSimpleName()) : value;
    }
}
