package org.example.beans;


import java.util.ArrayList;
import java.util.List;

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
