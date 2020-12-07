####
# This Dockerfile is used in order to build a container that runs the Quarkus application in native (no JVM) mode
#
# Before building the container image run:
#
# ./mvnw package -Pnative
#
# Then, build the image with:
#
# docker build -f src/main/docker/Dockerfile.native -t quarkus/homehunt .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 quarkus/homehunt
#
###

FROM registry.access.redhat.com/ubi8/ubi-minimal:8.3
WORKDIR /work/
COPY target/*-runner /work/application
RUN chmod 775 /work
CMD ./application -Dquarkus.http.host=0.0.0.0 -Dquarkus.http.port=${PORT}
