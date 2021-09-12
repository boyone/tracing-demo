FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# For MacOS, comment this line if you're using Linux
ENV JAEGER_ENDPOINT="http://host.docker.internal:14268/api/traces"
# For Linux, uncomment this line if you're using Linux
# ENV JAEGER_ENDPOINT="http://127.0.0.1:14268/api/traces"
ENV JAEGER_SAMPLER_TYPE=const
ENV JAEGER_SAMPLER_PARAM=1
ENV JAEGER_REPORTER_LOG_SPANS=true

ENTRYPOINT ["java","-jar","/app.jar"]