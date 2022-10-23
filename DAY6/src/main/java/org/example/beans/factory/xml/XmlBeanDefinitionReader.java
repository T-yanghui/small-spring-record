package org.example.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.example.beans.BeansException;
import org.example.beans.PropertyValue;
import org.example.beans.factory.config.BeanDefinition;
import org.example.beans.factory.config.BeanReference;
import org.example.beans.factory.support.AbstractBeanDefinitionReader;
import org.example.beans.factory.support.BeanDefinitionRegistry;
import org.example.core.io.Resource;
import org.example.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

import org.w3c.dom.*;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName XmlBeanDefinitionReader.java
 * @Description TODO
 * @createTime 2022/10/13
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new BeansException("IOException parsing XML document from " + resource, ex);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for(String location:locations){
            loadBeanDefinitions(location);
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (!(childNodes.item(i) instanceof Element)) continue;
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;
            //解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            //构造Beandefinition
            Class<?> clazz = Class.forName(className);
            String beanName = StrUtil.isEmpty(id) ? name : id;
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            //构造propertyValues
            NodeList propertyNodeList = bean.getChildNodes();
            for (int j = 0; j < propertyNodeList.getLength(); j++) {
                if (!(propertyNodeList.item(j) instanceof Element)) continue;
                if (!"property".equals(propertyNodeList.item(j).getNodeName())) continue;
                Element property = (Element) propertyNodeList.item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                Object value = (StrUtil.isEmpty(attrValue) ? new BeanReference(attrRef) : attrValue);
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            //注册BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
