FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY . .
RUN chmod +x gradlew
RUN ./gradlew build -x test

FROM eclipse-temurin:21-jre
WORKDIR /app

ENV TZ=Asia/Tokyo

ENV SPRING_PROFILES_ACTIVE=prod

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]