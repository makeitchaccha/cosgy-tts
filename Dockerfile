# two stage build
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# solve dependency
COPY pom.xml .
RUN mvn dependency:go-offline -B

# build
COPY . .
RUN mvn clean package -DskipTests

# runtime-base
FROM eclipse-temurin:21-jre-jammy AS base
WORKDIR /app

# MeCab + OpenJTalk（辞書と音声データなし）
RUN apt-get update && apt-get install -y \
    mecab \
    libmecab-dev \
    open-jtalk \
    && rm -rf /var/lib/apt/lists/*

COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]


# runtime-full with dictionary + hts-voices
FROM base AS full
WORKDIR /app

# install required packages
RUN apt-get update && apt-get install  -y \
    unzip \
    mecab-ipadic-utf8 \
    open-jtalk-mecab-naist-jdic \
    hts-voice-nitech-jp-atr503-m001 \
    && rm -rf /var/lib/apt/lists/*

# install voices
RUN mkdir -p /usr/share/hts-voice

RUN wget https://sourceforge.net/projects/mmdagent/files/MMDAgent_Example/MMDAgent_Example-1.8/MMDAgent_Example-1.8.zip && \
    unzip MMDAgent_Example-1.8.zip && \
    mv MMDAgent_Example-1.8/Voice/mei/*.htsvoice /usr/share/hts-voice/ && \
    mv MMDAgent_Example-1.8/Voice/takumi/*.htsvoice /usr/share/hts-voice/

ENTRYPOINT ["java", "-jar", "app.jar"]