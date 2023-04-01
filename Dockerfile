FROM openjdk:19
COPY target/caderno-de-contas-0.0.1-SNAPSHOT.jar /app/contas.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "contas.jar"]