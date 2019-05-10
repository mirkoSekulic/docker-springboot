# -----------------------------------------------------------------------------
# Build image
# -----------------------------------------------------------------------------
FROM maven:3.5.3-jdk-8-alpine AS MAVEN_TOOL_CHAIN

COPY pom.xml /tmp/
COPY src /tmp/src/

WORKDIR /tmp/
RUN mvn clean install -D skipTests

# -----------------------------------------------------------------------------
# Final image
# -----------------------------------------------------------------------------
FROM openjdk:8u191-jre-alpine

RUN mkdir /config
RUN mkdir /documents

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar app.jar

CMD ["/usr/bin/java", "-jar", "app.jar"]