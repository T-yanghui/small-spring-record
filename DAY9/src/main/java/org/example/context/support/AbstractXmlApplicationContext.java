package org.example.context.support;

import org.example.beans.factory.support.DefaultListableBeanFactory;
import org.example.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName AbstractXmlApplicationContext.java
 * @Description TODO
 * @createTime 2022/10/19
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if(null!=configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
