package org.example.beans.factory;

import org.example.beans.BeansException;
import org.example.beans.PropertyValue;
import org.example.beans.PropertyValues;
import org.example.beans.factory.config.BeanDefinition;
import org.example.beans.factory.config.BeanFactoryPostProcessor;
import org.example.core.io.DefaultResourceLoader;
import org.example.core.io.Resource;
import org.example.util.StringValueResolver;

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
                    value = resolvePlaceholder((String) value, properties);
                    propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), value));
                }
            }
            //add stringResolver to container
            StringValueResolver valueResolver=new PlaceholderResolvingStringValueResolver(properties);

        } catch (IOException ex) {
            throw new BeansException("Could not load properties", ex);
        }
    }

    private String resolvePlaceholder(String value, Properties properties) {
        String sVal = value;
        StringBuilder sb = new StringBuilder(sVal);
        int startIdx = sVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
        int stopIdx = sVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
        if ((startIdx < stopIdx) && (startIdx != -1) && (stopIdx != -1)) {
            String propertyKey = sVal.substring(startIdx + 2, stopIdx);
            String propertyVal = properties.getProperty(propertyKey);
            sb.replace(startIdx, stopIdx + 1, propertyVal);
        }
        return sb.toString();
    }

    private class PlaceholderResolvingStringValueResolver implements StringValueResolver {
        private final Properties properties;

        public PlaceholderResolvingStringValueResolver(Properties properties) {
            this.properties = properties;
        }

        @Override
        public String resolveStringValue(String strVal) {
            return resolvePlaceholder(strVal, properties);
        }
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
