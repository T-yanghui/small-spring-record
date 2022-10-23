package org.example.context.support;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName ClassPathXmlApplicationContext.java
 * @Description TODO
 * @createTime 2022/10/19
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    private String[] configLocations;

    public ClassPathXmlApplicationContext(String configLocation) {
        this(new String[]{configLocation});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return this.configLocations;
    }
}
