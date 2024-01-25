FROM openjdk:17
EXPOSE 9090
ADD target/projet-demo-app.jar projet-demo-app.jar
ENTRYPOINT  ["java" , "-jar","projet-demo-app.jar"]