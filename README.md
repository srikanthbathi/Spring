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


