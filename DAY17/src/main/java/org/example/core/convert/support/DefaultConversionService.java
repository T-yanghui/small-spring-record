package org.example.core.convert.support;

import org.example.core.convert.converter.ConverterRegistry;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName DefaultConversionService.java
 * @Description TODO
 * @createTime 2023/04/05
 */
public class DefaultConversionService extends GenericConversionService {

    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        // 添加各类类型转换工厂
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }

}
