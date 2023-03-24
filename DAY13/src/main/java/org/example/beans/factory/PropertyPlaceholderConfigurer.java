package org.example.beans.factory;

import org.example.beans.BeansException;
import org.example.beans.PropertyValue;
import org.example.beans.PropertyValues;
import org.example.beans.factory.config.BeanDefinition;
import org.example.beans.factory.config.BeanFactoryPostProcessor;
import org.example.core.io.DefaultResourceLoader;
import org.example.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName PropertyPlaceholderConfigurer.java
 * @Description TODO
 * @createTime 2023/03/24
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";
    private String location;

    @Override
    public void postProcessorBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            //load property file & init Properties object
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            //replace beanDefinition's propertyPlaceHolder
            String[] beaDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beaDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value;
                    if (!((value = propertyValue.getValue()) instanceof String)) {
                        continue;
                    }
                    String sVal = (String) value;
                    StringBuilder sb = new StringBuilder(sVal);
                    int startIdx = sVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int stopIdx = sVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if ((startIdx < stopIdx) && (startIdx != -1) && (stopIdx != -1)) {
                        String propertyKey = sVal.substring(startIdx + 2, stopIdx);
                        String propertyVal = properties.getProperty(propertyKey);
                        sb.replace(startIdx, stopIdx + 1, propertyVal);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), sb.toString()));
                    }
                }
            }
        } catch (IOException ex) {
            throw new BeansException("Could not load properties", ex);
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
