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
RUN chown 1001 /work \
    && chmod "g+rwX" /work \
    && chown 1001:root /work
COPY --chown=1001:root target/*-runner /work/application

USER 1001

# Port picked up by Heroku $PORT, instead of EXPOSE 8080 from the template
CMD ["sh", "./application", "-Dquarkus.http.host=0.0.0.0", "-Dquarkus.http.port=${PORT}"]
