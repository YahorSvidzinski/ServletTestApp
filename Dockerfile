FROM tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
# with following copy command it works, but when I rebuild war file, I need stop docker-compose and build and run it again .. I want use volume instead of copy war
#COPY ./pnp-web/target/pnp.war /usr/local/tomcat/webapps/ROOT.war
COPY ./target/servlet-test-web-xml-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/root.war
CMD ["catalina.sh", "run"]