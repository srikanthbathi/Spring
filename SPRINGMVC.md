
[ApplicationContext Vs WebApplicationContext](#appContext)

## AppContext

**ApplicationContext** applicationContext.xml is the root context configuration for every web application. Spring loads applicationContext.xml file and creates the ApplicationContext for the whole application. There will be only one application context per web application. If you are not explicitly declaring the context configuration file name in web.xml using the contextConfigLocation param, Spring will search for the applicationContext.xml under WEB-INF folder and throw FileNotFoundException if it could not find this file.


**WebApplicationContext** Apart from ApplicationContext, there can be multiple WebApplicationContext in a single web application. In simple words, each DispatcherServlet associated with single WebApplicationContext. xxx-servlet.xml file is specific to the DispatcherServlet and a web application can have more than one DispatcherServlet configured to handle the requests. In such scenrios, each DispatcherServlet would have a separate xxx-servlet.xml configured. But, applicationContext.xml will be common for all the servlet configuration files. Spring will by default load file named “xxx-servlet.xml” from your webapps WEB-INF folder where xxx is the servlet name in web.xml. If you want to change the name of that file name or change the location, add initi-param with contextConfigLocation as param name.

**Auto-configuration**
Spring Boot auto-configuration attempts to automatically configure your Spring application based on the jar dependencies that you have added. For example, if HSQLDB is on your classpath, and you have not manually configured any database connection beans, then Spring Boot auto-configures an in-memory database.

You need to opt-in to auto-configuration by adding the @EnableAutoConfiguration or @SpringBootApplication annotations to one of your @Configuration classes.


https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-auto-configuration.html


[Tip]
You should only ever add one @SpringBootApplication or @EnableAutoConfiguration annotation. We generally recommend that you add one or the other to your primary @Configuration class only.


**Spring Bean Scope for Web**
Spring Framework new release 4.3 make some Web Improvements. Among that, it simplifies way to implement Bean Scopes (Request, Session and Application scopes) using Annotation: @RequestScope | @SessionScope | @ApplicationScope. They are only valid in the context of a web-aware Application.

http://javasampleapproach.com/spring-framework/spring-bean-scope-annotation-requestscope-sessionscope-applicationscope




