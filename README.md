# Servlet test application

## Prerequisites
* Maven 
* Java 1.8
* Docker, [Docker-compose](https://docs.docker.com/compose/)
* Tomcat

## Build project

Open your project package in cmd

```
mvn clean package
```
## Launch application

```
docker-compose up
```

Note: you can configure database creation in ```docker-compose.yml``` file **db** section.
Database credentials could be changed in ```db.properties``` file


* Request
http://localhost:8082/servlet/students

List of stored users should be showed.

Note: Port and deployed war file name could be configured in docker ```docker-compose.yml``` **tomcat** section.

