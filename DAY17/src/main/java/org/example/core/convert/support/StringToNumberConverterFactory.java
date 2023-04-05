package org.example.core.convert.support;

import org.example.core.convert.converter.Converter;
import org.example.core.convert.converter.ConverterFactory;
import org.example.util.NumberUtils;

import javax.annotation.Nullable;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName StringToNumberConverterFactory.java
 * @Description TODO
 * @createTime 2023/04/05
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {

    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<>(targetType);
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T> {

        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        @Nullable
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }
            return NumberUtils.parseNumber(source, this.targetType);
        }
    }

}
