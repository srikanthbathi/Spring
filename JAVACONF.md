[PropertySourcesPlaceholderConfigurer](#PropertySourcesPlaceholderConfigurer)

[AnnotationConfigApplicationContext](#AnnotationConfigApplicationContext)


## PropertySourcesPlaceholderConfigurer 

PropertySourcesPlaceholderConfigurer class is used to externalize the Properties you want to use in a property file.

@Configuration

public class AppConfig{

@Bean

public PropertySourcesPlaceholderConfigure propertySourcesPlaceholderConfigurer(){

 PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
 
 propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("application-db.properties"));
 
return propertySourcesPlaceholderConfigurer;

}

}



Here we have created the location to search for the property file using class path

## AnnotationConfigApplicationContext

