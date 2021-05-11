# springboot-java-hibernate-rest-sql 🛋️

This Project is a working example of 🚀 a java application server that exposes REST endpoints and connects to a database


# How To Run 🏃
>	Its Simple!

**Step 1:** checkout this repository ( `git clone https://github.com/eaccmk/springboot-java-hibernate-rest-sql` )

**Step 2:** Open Project (In your favourite IDE, I have used [Intellij] )

**Step 3:** Open your terminal/cmd and run `mvn clean install`

**Step 4:** Once done, Run this `java` application using :

  `./mvn package && java -jar target/spring-boot-rest-api-java-app-0.1.0.jar`

Once succes you will see this message `Started Application in 7.376 seconds (JVM running for 9.934)` such as this :

```console
[INFO]
[INFO] --- spring-boot-maven-plugin:2.3.0.RELEASE:repackage (repackage) @ springboot-java-hibernate-rest-sql ---
[INFO] Replacing main artifact with repackaged archive
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  21.657 s
[INFO] Finished at: 2021-05-10T08:15:00+10:00
[INFO] ------------------------------------------------------------------------

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.0.RELEASE)

2021-05-10 08:15:05.859  INFO 4400 --- [           main] app.Application                          : Starting Application v0.1.0 on <machine_name> with PID 4400 ( <your_project_path>...)
2021-05-10 08:15:05.874  INFO 4400 --- [           main] app.Application                          : No active profile set, falling back to default profiles: default
2021-05-10 08:15:09.454  INFO 4400 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2021-05-10 08:15:09.514  INFO 4400 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-05-10 08:15:09.515  INFO 4400 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.35]
2021-05-10 08:15:09.826  INFO 4400 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-05-10 08:15:09.827  INFO 4400 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 3450 ms
2021-05-10 08:15:10.239  INFO 4400 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-05-10 08:15:10.864  INFO 4400 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-05-10 08:15:10.917  INFO 4400 --- [           main] app.Application                          : Started Application in 7.376 seconds (JVM running for 9.934)

```

In a hurry ? , you can run the project without running the test's (although, not recommended) just add `mvn`'s `-DskipTests` tag :

`./mvnw -DskipTests package && java -jar target/spring-boot-rest-api-java-app-0.1.0.jar`

**Step 5:** To verify the application hit `curl localhost:8080/` and you must see

```
Welcome! - Springboot + java + Hibernate + Rest API

Need more interesting projects, follow me @ https://github.com/eaccmk

```

**Step 6:** Need to know more about automation testing including this one, pick an example from my [Test-Automation-Project-POCs]

### Project Structure

```console
.
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── src
   ├── main
   │   ├── java
   │   │   ├── app
   │   │   │   ├── Application.java
   │   │   │   └── service
   │   │   │       └── BookController.java
   │   │   ├── dao
   │   │   │   ├── BookDao.java
   │   │   │   └── BookOperations.java
   │   │   ├── dto
   │   │   │   └── bookDto.java
   │   │   ├── entity
   │   │   │   └── Book.java
   │   │   └── util
   │   │       └── HibernateUtil.java
   │   ├── main.iml
   │   └── resources
   │       ├── application.yml
   │       └── hibernate.cfg.xml
   └── test
       ├── java
       │   └── app
       │       └── ServerConfigurationTests.java
       └── test.iml
```

Not more documentation on all the implemented endpoints `GET, POST , PUT, DELETE` covering CRUD operation, go here to get more [HELP!]
# Credits 🙏

Thank you for providing helpful guide, while I was setting up this framework.
- Building an Application with Spring Boot from [spring.io]
- Setting hibernate config from this [HibernateDemo] repo by [anicetkeric]
- My Sql Db used is open source Database provided by [Maria DB]


## License 🔰

**springboot-java-hibernate-rest-sql** was released under [MIT License](LICENSE)


[\\]: <> (This is a commented section and should not be visible in README file)

[HELP!]: <wiki/README.md>
[Test-Automation-Project-POCs]: <https://github.com/eaccmk/Test-Automation-Project-POCs>
[Intellij]: <https://www.jetbrains.com/idea/download/>
[HibernateDemo]: <https://github.com/anicetkeric/HibernateDemo>
[anicetkeric]: <https://github.com/anicetkeric>
[Maria DB]: <https://mariadb.com/kb/en/show-databases/>
[spring.io]: <https://spring.io/guides/gs/spring-boot/>