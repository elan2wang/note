---
layout: post
title: Spring相关技术
tags: spring
categories: java
---
### 1. 注解相关
1. @Component,@Repository,@Service,@Controller  
这四个注解是由Spring框架定义的，用于标注类。目前这四种注释是等效的，但是Spring以后必定会给它们添加特殊的功能。根据词的语意也可以看出@Repository是对应持久层，@Service对应业务层，@Controller对应控制层，@Component泛指组件。  
Spring2.5以后引入了组件自动扫瞄机制，它可以在类路径下寻找标注了@Component,@Repository,@Service和@Controller注解的类，并把这些类纳入Spring容器中管理，它的作用和在ApplicationContext.xml中使用bean节点配置组件时一样。要使用自动扫描机制，需要在ApplicationContext.xml文件中添加以下配置信息：  
<code><context:component-scan base-package="com.bmp" /></code>  
<code><context:annotation-config /></code>  
base-package属性表示需要扫瞄的包的目录，自己根据项目进行配置。  
Spring容器会自动根据类名实例化一个**首字母小写**的对象，如果需要自己命名实例化对象可以通过@Service("selfDefinedName")。Spring容器创建的对象**默认是单例**的，如果要改变可以使用@Service("beanName")@Scope("prototype")来改变。另外还可以使用JSR-250规范定义的注解@PostConstruct和@PreDestroy来标注初始化方法和销毁方法。

2.  @Autowired与@Resource的区别  
@Resource是由JSR-250规范定义的，@Autowired是由Spring框架定义的。它的作用都是自动注入，只是@Resource默认是按byName注入，而@Autowired默认是按byType注入的。  
@Resource的两个重要属性是**name和type**，Spring将@Resource注解的name属性解析为bean的名字，而type属性则解析为bean的类型，所以如果使用name属性，则**仅使用byName的自动注入策略**(如果找不到指定名称的对象则会抛异常)，而使用type属性时则**仅使用byType自动注入策略**。如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。  
如果@Autowired也想使用名称装配可以结合@Qualifier注解进行使用。
>@Autowired() @Qualifier("baseDao")  
>private BaseDao baseDao;  