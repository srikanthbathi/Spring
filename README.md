[Spring Java config Methods](./JAVACONF.md)

[Spring Annotations](./ANNOTATIONS.md)


https://orga.cat/posts/most-useful-git-commands

https://howtodoinjava.com/spring-security-tutorial/

https://www.callicoder.com/documenting-spring-rest-apis-using-swagger/

**SPRING IOC Container** -- [Inversion of control is nothing but outsourcing the creation, managing and configuring the objects.]

The spring container is the core of Spring framework. This container creates the objects, wire them together and manage their complete life cycle. The Primary function of the IOC Container is to create and manage POJO's by means of DI(Dependency injection) 

**Dependency Injection**-- [DI is a design pattern which enables the computer program developers to implement loosely coupled code by injecting objects to classes in spite of creating objects inside a class. This gives the code which is loosely coupled maintainable and testable.]

**Bean** - A POJO that is created, managed and configured by spring container is refered as spring bean.

The spring container gets its instructions on what objects to instantiate, configure, and assemble by reading the configuration metadata provide. This metadata can be represented either by XML, Java Annotations, or Java code.


SPRING Provides two distinct type of Containers.

1. **Spring BeanFactory container**-- 
This is the simplest container providing the basic support for DI and defined by the org.springframework.beans.factory.BeanFactory interface. The BeanFactory and related interfaces, such as BeanFactoryAware, InitializingBean, DisposableBean, are still present in Spring for the purpose of backward compatibility with a large number of third-party frameworks that integrate with Spring.

There are a number of implementations of the BeanFactory interface that are come straight out-of-the-box with Spring. The most commonly used BeanFactory implementation is the XmlBeanFactory class. This container reads the configuration metadata from an XML file and uses it to create a fully configured system or application.

The BeanFactory is usually preferred where the resources are limited like mobile devices or applet-based applications. Thus, use an ApplicationContext unless you have a good reason for not doing so.


2. **Spring ApplicationContext Container**--

The Application Context is Spring's advanced container. Similar to BeanFactory, it can load bean definitions, wire beans together, and dispense beans upon request. Additionally, it adds more enterprise-specific functionality such as the ability to resolve textual messages from a properties file and the ability to publish application events to interested event listeners. This container is defined by org.springframework.context.ApplicationContext interface.

The ApplicationContext includes all functionality of the BeanFactory, It is generally recommended over BeanFactory. BeanFactory can still be used for lightweight applications like mobile devices or applet-based applications.

The most commonly used ApplicationContext implementations are −

**FileSystemXmlApplicationContext** − This container loads the definitions of the beans from an XML file. Here you need to provide the full path of the XML bean configuration file to the constructor.

**ClassPathXmlApplicationContext** − This container loads the definitions of the beans from an XML file. Here you do not need to provide the full path of the XML file but you need to set CLASSPATH properly because this container will look like bean configuration XML file in CLASSPATH.

**WebXmlApplicationContext** − This container loads the XML file with definitions of all beans from within a web application.

--> Post construct.
--> java.util.TimerTask


--> com.medlife.customer.controller.CustomerController.authenticateUserAndSetSession(String, String, HttpServletRequest)
--> 




3.4.2.1. BeanFactoryAware
A class which implements the org.springframework.beans.factory.BeanFactoryAware interface is provided with a reference to the BeanFactory that created it, when it is created by that BeanFactory.

public interface BeanFactoryAware {
   /**
    * Callback that supplies the owning factory to a bean instance.
    * <p>Invoked after population of normal bean properties but before an init
    * callback like InitializingBean's afterPropertiesSet or a custom init-method.
    * @param beanFactory owning BeanFactory (may not be null).
    * The bean can immediately call methods on the factory.
    * @throws BeansException in case of initialization errors
    * @see BeanInitializationException
    */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
This allows beans to manipulate the BeanFactory that created them programmatically, through the org.springframework.beans.factory.BeanFactory interface, or by casting the reference to a known subclass of this which exposes additional functionality. Primarily this would consist of programmatic retrieval of other beans. While there are cases when this capability is useful, it should generally be avoided, since it couples the code to Spring, and does not follow the Inversion of Control style, where collaborators are provided to beans as properties.

3.4.2.2. BeanNameAware
If a bean implements the org.springframework.beans.factory.BeanNameAware interface and is deployed in a BeanFactory, the BeanFactory will call the bean through this interface to inform the bean of the id it was deployed under. The callback will be Invoked after population of normal bean properties but before an init callback like InitializingBean's afterPropertiesSet or a custom init-method.


3.7. Customizing beans with BeanPostProcessors
A bean post-processor is a java class which implements the org.springframework.beans.factory.config.BeanPostProcessor interface, which consists of two callback methods. When such a class is registered as a post-processor with the BeanFactory, for each bean instance that is created by the BeanFactory, the post-processor will get a callback from the BeanFactory before any initialization methods (afterPropertiesSet and any declared init method) are called, and also afterwords. The post-processor is free to do what it wishes with the bean, including ignoring the callback completely. A bean post-processor will typically check for marker interfaces, or do something such as wrap a bean with a proxy. Some Spring helper classes are implemented as bean post-processors.

It is important to know that a BeanFactory treats bean post-processors slightly differently than an ApplicationContext. An ApplicationContext will automatically detect any beans which are deployed into it which implement the BeanPostProcessor interface, and register them as post-processors, to be then called appropriately by the factory on bean creation. Nothing else needs to be done other than deploying the post-processor in a similar fashion to any other bean. On the other hand, when using plain BeanFactories, bean post-processors have to manually be explicitly registered, with a code sequence such as the following:

ConfigurableBeanFactory bf = new .....;     // create BeanFactory
   ...                       // now register some beans
// now register any needed BeanPostProcessors
MyBeanPostProcessor pp = new MyBeanPostProcessor();
bf.addBeanPostProcessor(pp);

// now start using the factory
  ...
Since this manual registration step is not convenient, and ApplictionContexts are functionally supersets of BeanFactories, it is generally recommended that ApplicationContext variants are used when bean post-processors are needed.

3.8. Customizing bean factories with BeanFactoryPostProcessors
A bean factory post-processor is a java class which implements the org.springframework.beans.factory.config.BeanFactoryPostProcessor interface. It is executed manually (in the case of the BeanFactory) or automatically (in the case of the ApplicationContext) to apply changes of some sort to an entire BeanFactory, after it has been constructed. Spring includes a number of pre-existing bean factory post-processors, such as PropertyResourceConfigurer and PropertyPlaceHolderConfigurer, both described below, and BeanNameAutoProxyCreator, very useful for wrapping other beans transactionally or with any other kind of proxy, as described later in this manual. The BeanFactoryPostProcessor can be used to add custom editors (as also mentioned in Section 3.9, “Registering additional custom PropertyEditors”).

In a BeanFactory, the process of applying a BeanFactoryPostProcessor is manual, and will be similar to this:

XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
// create placeholderconfigurer to bring in some property
// values from a Properties file
PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
cfg.setLocation(new FileSystemResource("jdbc.properties"));
// now actually do the replacement
cfg.postProcessBeanFactory(factory);
An ApplicationContext will detect any beans which are deployed into it which implement the BeanFactoryPostProcessor interface, and automatically use them as bean factory post-processors, at the appropriate time. Nothing else needs to be done other than deploying these post-processor in a similar fashion to any other bean.

Since this manual step is not convenient, and ApplictionContexts are functionally supersets of BeanFactories, it is generally recommended that ApplicationContext variants are used when bean factory post-processors are needed.

https://docs.spring.io/spring/docs/1.2.x/reference/beans.html


