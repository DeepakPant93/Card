# Building the Project
FROM maven:3.6.3-openjdk-14
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn clean package -DskipTests

# Deploying the Project
FROM openjdk:14
WORKDIR /app
COPY --from=0 /build/target/*.jar /app/card.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "card.jar"]