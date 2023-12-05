FROM openjdk:17-alpine
COPY target/maestros-0.0.1-SNAPSHOT.jar /app/
EXPOSE 6061
#ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Duser.timezone=America/Lima", "-Xms32m", "-Xmx64m", "-jar", "/app/application.jar", "server", "--spring.config.location=file:/config/application.yaml"]
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Duser.timezone=America/Lima", "-Xms32m", "-Xmx64m", "-jar", "/app/maestros-0.0.1-SNAPSHOT.jar", "server"]
