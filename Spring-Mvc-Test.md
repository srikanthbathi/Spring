# SPRING MVC Test

[@WebAppConfiguration](#webAppConfiguration)



## WebAppConfiguration

Annotating with **@WebAppConfiguration** tells the TestContext framework to load wep application context i.e it denotes the context to be WebAppContext. 

**Configures the resource path for web app**
  - Used by MockServletContext
  - Defaults to src/main/webapp
  - Paths are file-system path, i.e folder relative to project root not classpath resource
  - The classpath: prefix is not supported

