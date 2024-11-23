ARG MAVEN_TAG=3.8.3-openjdk-17
ARG JDK_TAG=17-jdk-slim
ARG PORT=8081

FROM maven:${MAVEN_TAG} as maven-build

WORKDIR /opt/app/

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests


# Target container
FROM  openjdk:${JDK_TAG}

COPY --from=maven-build /opt/app/target/*.jar app.jar

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]