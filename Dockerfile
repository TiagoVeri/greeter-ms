FROM openjdk:17
WORKDIR /app

COPY target/*.jar /app/application.jar

CMD ["java", "-jar", "application.jar"]