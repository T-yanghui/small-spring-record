package org.example.context.support;

import org.example.beans.factory.FactoryBean;
import org.example.beans.factory.InitializingBean;
import org.example.core.convert.ConversionService;
import org.example.core.convert.converter.Converter;
import org.example.core.convert.converter.ConverterFactory;
import org.example.core.convert.converter.ConverterRegistry;
import org.example.core.convert.converter.GenericConverter;
import org.example.core.convert.support.DefaultConversionService;
import org.example.core.convert.support.GenericConversionService;

import javax.annotation.Nullable;
import java.util.Set;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ConversionServiceFactoryBean.java
 * @Description TODO
 * @createTime 2023/04/05
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {

    @Nullable
    private Set<?> converters;

    @Nullable
    private GenericConversionService conversionService;

    @Override
    public ConversionService getObject() throws Exception {
        return conversionService;
    }

    @Override
    public Class<?> getObjectType() {
        return conversionService.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.conversionService = new DefaultConversionService();
        registerConverters(converters, conversionService);
    }

    private void registerConverters(Set<?> converters, ConverterRegistry registry) {
        if (converters != null) {
            for (Object converter : converters) {
                if (converter instanceof GenericConverter) {
                    registry.addConverter((GenericConverter) converter);
                } else if (converter instanceof Converter<?, ?>) {
                    registry.addConverter((Converter<?, ?>) converter);
                } else if (converter instanceof ConverterFactory<?, ?>) {
                    registry.addConverterFactory((ConverterFactory<?, ?>) converter);
                } else {
                    throw new IllegalArgumentException("Each converter object must implement one of the " +
                            "Converter, ConverterFactory, or GenericConverter interfaces");
                }
            }
        }
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }

}
