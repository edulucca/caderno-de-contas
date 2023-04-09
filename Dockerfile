FROM eclipse-temurin:19

COPY target/caderno-de-contas-0.0.1-SNAPSHOT.jar /app/app.jar

COPY pom.xml .

WORKDIR /app

#RUN mvn clean install

#CMD mvn org.springframework.boot:spring-boot-maven-plugin:run

ENTRYPOINT ["java", "-jar", "app.jar"]