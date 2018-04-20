[@Configuration](#configuration)

[@Bean](#bean)

[@Import](#import)


## Configuration 

Indicates that the class annotated with configure annotation can be used by spring IOC container as a source to get the bean definitions.

@Configuration

public class AppConfig1{

    @Bean  
    public getAddress(){
    return new Address();
    }
    ...
}


## Bean

Indicates the spring container that the method annotated with Bean will return the object that can be registerd as a bean in Spring application context.



## Import

This annotation is use to import bean definitions from another configuration class.

**Example**




@Configuration

@Import(AppConfig1.class)

public class AppConfig{

    @Bean  
    public getEmployee(){
    return new Employee();
    }
    ...
}




