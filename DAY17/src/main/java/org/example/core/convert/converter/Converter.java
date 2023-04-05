package org.example.core.convert.converter;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName Converter.java
 * @Description TODO
 * @createTime 2023/04/05
 */
public interface Converter<S, T> {
    T convert(S source);
}
