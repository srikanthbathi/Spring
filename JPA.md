Basically JPA specification defines two types of entity managers. They are :

i) Application-Managed : Application Managed entity manager means "Entity Managers are created and managed by merely the application ( i.e. our code )" .

ii) Container Managed : Container Managed entity manager means "Entity Managers are created and managed by merely the J2EE container ( i.e. our code doesn't directly manages instead entity managers are created and managed by container , and our codes gets EM's through some way like using JNDI ).

Note : Created and Managed (above) means "opening , closing and involving entity manager in transactions"

LocalContainerEntityManagerFactoryBean - container managed 
LocalEntityManagerFactoryBean - application managed

A Big Note : For spring based applications, the difference is not much. Spring only plays roles ( as container if you configure LocalContainerEntityManagerFactoryBean and as application if you configure LocalEntityManagerFactoryBean)
