FROM openjdk:17
LABEL maintainer="vishu config"
LABEL description="config"
ADD target/config-1.0.jar config-1.0.jar
COPY config-1.0.jar /opt/vishal/
WORKDIR /opt/vishal/
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "config-1.0.jar"]