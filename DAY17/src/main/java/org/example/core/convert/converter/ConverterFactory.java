package org.example.core.convert.converter;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ConverterFactory.java
 * @Description TODO
 * @createTime 2023/04/05
 */
public interface ConverterFactory<S, R> {
    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
