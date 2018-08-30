# micro-SpringFramwork

简单的springFramwork，基于注解方式，实现了IOC的bean注入功能。

## 项目目的

注入的原理清楚了之后，有强烈的欲望去实现一个bean的管理器，做一个最基础的demo。

我在 https://github.com/code4craft/tiny-spring 这个项目找到了一个简单的spring框架，但其工程目的，更偏向于framewore的解析，分析它的结构。

对我来说，这太多冗余了，再次说明：**我们要做一个最基础的bean管理，而不是迷失在接口与抽象类，扩展性和安全性中。**

## 项目结构

项目只有三个重要的类
- MyBean 定义"MyBean"注解
- BeanDefination 定义Bean
- ApplicationContex 这是重点。负责bean的注册和管理

ApplicationContex 类的重要方法：
- loadClassName(String path) 根据path获得包下所有的类，递归实现，并且剔除了"test-classes"
- regist(List<String> className) 根据类名加载类，过滤剩下"MyBean"修饰的类，并保存到beanDefinitionMap
- getBean(String name) 根据类名获得可用的bean


## 启动引导

test包下有ApplicationContexTest，这是一个JUnitTest，运行Test()方法即可看到效果。


