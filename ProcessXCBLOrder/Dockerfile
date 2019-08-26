FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/ProcessXCBLOrder-0.0.1-SNAPSHOT.jar ProcessXCBLOrder.jar
EXPOSE 8084
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ProcessXCBLOrder.jar"]