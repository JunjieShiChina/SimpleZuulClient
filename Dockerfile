FROM java:8
MAINTAINER junjieshi
ADD SimpleZuulClient.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8770
ENTRYPOINT ["java", "-jar","/app.jar"]