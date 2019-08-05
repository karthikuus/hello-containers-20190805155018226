# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

RUN apt-get -qq update && \
    apt-get -q -y install \
    maven \
    && apt-get clean && apt-get autoclean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* /var/cache/* ~/.cache
