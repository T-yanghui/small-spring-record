# small-spring-record

记录复现学习spring的过程

## DAY-1  简单bean容器

引入beandefinition 和 beanfactory的概念，但和实际spring的实现相差很大

## DAY-2 bean的定义注册和获取

根据bean实例化的过程，按功能分为单例注册、beanDefinition注册、单例获取，分别由接口，抽象类实现

## DAY-3 定义bean的实例化策略

使用Cglib和JDK实现类实例化构造器的选择

## DAY-4 完成bean简单的属性注入

选择无参构造器，初始化完成后，直接利用反射对对象属性赋值
