FROM openjdk:11
MAINTAINER emelceledonio.io
RUN addgroup -S devcenter && adduser -S devecenter -G devcenter
USER devcenter:devcenter
ARG JAR_FILE=out/artifacts/DesafioAPIH2_jar/*.jar
COPY ${JAR_FILE} DesafioAPIH2.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/DesafioAPIH2.jar"]
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar desafioapih2.jar
