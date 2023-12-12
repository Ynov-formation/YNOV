FROM openjdk:17 as builder
ARG BRANCH
ENV ENVIRONMENT=${BRANCH}
RUN mkdir src
COPY . /src
WORKDIR /src

RUN chmod 700 mvnw && ./mvnw clean install package -Dmaven.test.skip=true




FROM openjdk:17-alpine
ARG BRANCH
ENV ENVIRONMENT=${BRANCH}

LABEL maintainer="arnaud.guetin@ynov.com"
COPY --from=builder /src/target /build
WORKDIR /build

EXPOSE 8082

ENTRYPOINT ["java","-Dspring.profiles.active=${ENVIRONMENT}", "-jar", "registry-0.0.1-SNAPSHOT.jar"]