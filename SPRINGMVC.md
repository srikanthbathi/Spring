
[ApplicationContext Vs WebApplicationContext](#appContext)

## AppContext

**ApplicationContext** applicationContext.xml is the root context configuration for every web application. Spring loads applicationContext.xml file and creates the ApplicationContext for the whole application. There will be only one application context per web application. If you are not explicitly declaring the context configuration file name in web.xml using the contextConfigLocation param, Spring will search for the applicationContext.xml under WEB-INF folder and throw FileNotFoundException if it could not find this file.
