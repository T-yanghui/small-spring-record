package org.example.factory;

import org.example.PropertyValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName PropertyValues.java
 * @Description TODO
 * @createTime 2022/10/11
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }
    public PropertyValue getPropertyValue(final String name){
        return propertyValueList.stream().filter(e->e.getName().equals(name))
                .findAny().orElse(null);
    }
    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }
}
