package org.example.beans;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName PropertyValue.java
 * @Description TODO
 * @createTime 2022/10/11
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
