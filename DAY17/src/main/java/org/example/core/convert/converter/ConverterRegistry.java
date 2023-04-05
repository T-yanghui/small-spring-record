package org.example.core.convert.converter;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ConverterRegistry.java
 * @Description TODO
 * @createTime 2023/04/05
 */
public interface ConverterRegistry {
    void addConverter(Converter<?,?> converter);
    void addConverter(GenericConverter converter);
    void addConverterFactory(ConverterFactory<?,?> converterFactory);
}
