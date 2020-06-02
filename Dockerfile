# Building the Project
FROM maven:3.6.3-openjdk-14
WORKDIR /build/
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src /build/src/
RUN mvn clean package -DskipTests

# Deploying the Project
FROM openjdk:14
WORKDIR /app
COPY --from=0 /build/target/*.jar /app/card.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "card.jar"]