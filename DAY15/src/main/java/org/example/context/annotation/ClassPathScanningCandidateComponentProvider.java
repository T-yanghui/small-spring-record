package org.example.context.annotation;

import cn.hutool.core.util.ClassUtil;
import org.example.beans.factory.config.BeanDefinition;
import org.example.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ClassPathScanningCandidateComponentProvider.java
 * @Description TODO
 * @createTime 2023/03/24
 */
public class ClassPathScanningCandidateComponentProvider {
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for(Class<?>clazz:classes){
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
