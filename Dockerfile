# Dockerfile to build API Service Container
############################################################
FROM openjdk:17-alpine
MAINTAINER TPP <dfernandez@tpp.com.pe>
COPY /var/jenkins_home/workspace/maestros_main/target/maestros-0.0.1-SNAPSHOT.jar /app/application.jar
#COPY src/main/resources/application.yml /config/application.yaml
#COPY src/main/resources/logback.xml /config/logback.xml
EXPOSE 6061
#ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Duser.timezone=America/Lima", "-Xms32m", "-Xmx64m", "-jar", "/app/application.jar", "server", "--spring.config.location=file:/config/application.yaml"]
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Duser.timezone=America/Lima", "-Xms32m", "-Xmx64m", "-jar", "/app/application.jar", "server"]
