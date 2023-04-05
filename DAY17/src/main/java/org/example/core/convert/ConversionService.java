package org.example.core.convert;

import javax.annotation.Nullable;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ConversionService.java
 * @Description TODO
 * @createTime 2023/04/05
 */
public interface ConversionService {
    /**
     * Return {@code true} if objects of {@code sourceType} can be converted to the {@code targetType}.
     */
    boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType);

    /**
     * Convert the given {@code source} to the specified {@code targetType}.
     */
    <T> T convert(Object source, Class<T> targetType);
}
