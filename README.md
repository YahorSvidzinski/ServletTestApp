# Servlet test application

## Prerequisites
* Maven 
* Java 1.8
* Docker, [Docker-compose](https://docs.docker.com/compose/)
* Tomcat
* IntelliJ IDEA 

## Build project

Open your project package in cmd

```
mvn clean package
```
## Launch application

 * Run MySQL Database
```
docker-compose up
```
Note: you can configure database creation in ```docker-compose.yml``` file.
Database credentials could be changed in ```db.properties``` file

* Deploy created war file to tomcat

1. Open IntelliJ IDEA - > Edit Configurations -> Add New Configuration -> Tomcat
2. Select path to your Tomcat directory.
3. Select deployed war file.
4. Run application.

* Request
http://{tomcat-url}/users

List of stored users should be showed.

