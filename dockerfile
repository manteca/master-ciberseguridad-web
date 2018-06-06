FROM ingensi/oracle-jdk
MAINTAINER Felipe Villalobos

RUN yum update -y && yum install -y unzip
RUN curl -O https://downloads.typesafe.com/play/1.4.4/play-1.4.4.zip
#RUN unzip typesafe-activator-1.3.6.zip -d / && rm typesafe-activator-1.3.6.zip && chmod a+x /activator-1.3.6/activator
RUN unzip play-1.4.4.zip -d /opt && mv /opt/play-1.4.4 /opt/play && rm play-1.4.4.zip && chmod a+x /opt/play/play
ENV PATH $PATH:/opt/play

EXPOSE 9000 8888
RUN mkdir /app
WORKDIR /app

CMD ["play", "run"]
