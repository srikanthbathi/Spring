
[ApplicationContext Vs WebApplicationContext](#appContext)

## AppContext

**ApplicationContext** applicationContext.xml is the root context configuration for every web application. Spring loads applicationContext.xml file and creates the ApplicationContext for the whole application. There will be only one application context per web application. If you are not explicitly declaring the context configuration file name in web.xml using the contextConfigLocation param, Spring will search for the applicationContext.xml under WEB-INF folder and throw FileNotFoundException if it could not find this file.


**WebApplicationContext** Apart from ApplicationContext, there can be multiple WebApplicationContext in a single web application. In simple words, each DispatcherServlet associated with single WebApplicationContext. xxx-servlet.xml file is specific to the DispatcherServlet and a web application can have more than one DispatcherServlet configured to handle the requests. In such scenrios, each DispatcherServlet would have a separate xxx-servlet.xml configured. But, applicationContext.xml will be common for all the servlet configuration files. Spring will by default load file named “xxx-servlet.xml” from your webapps WEB-INF folder where xxx is the servlet name in web.xml. If you want to change the name of that file name or change the location, add initi-param with contextConfigLocation as param name.


