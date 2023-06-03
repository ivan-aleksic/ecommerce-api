FROM openjdk:11-jre
COPY target/spring-boot-ecommerce-0.0.1-SNAPSHOT.jar ecommerce.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ecommerce.jar"]
