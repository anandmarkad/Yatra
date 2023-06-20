FROM tomcat:8.0.51-jre8-alpine
COPY ./target/yatra-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps
EXPOSE 8080
USER yatra
WORKDIR /usr/local/tomacat/webapps
CMD["catalina.sh","run"]