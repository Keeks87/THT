FROM openjdk:8-jdk-alpine
COPY . /usr/src/saynumber
WORKDIR /usr/src/saynumber
RUN apk add --no-cache git && \
    git clone https://github.com/junit-team/junit4.git && \
    javac -cp junit4/:. SayNumber.java
CMD ["java", "-cp", "junit4/:.", "SayNumber"]
