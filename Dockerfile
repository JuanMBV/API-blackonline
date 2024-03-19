FROM eclipse-temurin:17

LABEL author=JuanMBV

COPY target/blackonline-0.0.1-SNAPSHOT.jar api_blackonline.jar

ENTRYPOINT [ "java", "-jar", "api_blackonline.jar"]