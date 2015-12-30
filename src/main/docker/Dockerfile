FROM java:8
VOLUME /tmp
ADD com.basilio.hiit-0.0.1-SNAPSHOT.jar hiit.jar
RUN bash -c 'touch /hiit.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=hsqldb","-jar","/hiit.jar"]
