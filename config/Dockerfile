FROM openjdk:17
LABEL maintainer="vishu config"
LABEL description="config"
ADD config/target/config-1.0.jar config-1.0.jar
ENTRYPOINT ["java", "-jar", "config-1.0.jar"]