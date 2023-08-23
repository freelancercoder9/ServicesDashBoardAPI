FROM eclipse-temurin:17-jdk-alpine as build
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
# WORKDIR /app
# COPY mvnw .
# COPY .mvn .mvn
# COPY pom.xml .
# RUN ./mvnw dependency:go-offline -B
# COPY src src
# RUN ./mvnw package -DskipTests
# RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)