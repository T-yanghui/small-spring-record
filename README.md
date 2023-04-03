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

## DAY_5 完成XML配置文件读取

主要实现XMLbeanDefinitionReader和ResourceLoader

## DYA_6 完成ApplicationContext refresh部分

主要创建了refresh的模板，完成BeanFactoryPostProcessor和BeanPostProcessor两个接口的实现

## DAY_7 完成init method方法和销毁的钩子函数

主要是添加init-method 和 destroy-method的实现

## DAY_8 Add marker superinterface & enable bean aware of spring framework.

## DAY_9 Add FactoryBean & implement bean's scop in IOC container

## DAY_10 create event and listener mechanism

## DAY_11 finished AOP core implements
## DAY_12 forgot :(

## DAY_13 Accomplish Bean-Scan registry & propertyPlaceholder fill

## DAY_14 add 'value' 'autowire' annotation

## DAY_15 apply properties to proxy_object 