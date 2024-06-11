FROM amazoncorretto:21
MAINTAINER staleks@gmail.com

VOLUME /var/log/template-goose

ADD build/libs/app-*.jar /opt/app.jar

ADD ./start-activity.sh /opt/start-activity.sh
RUN chmod +x /opt/start-activity.sh

ENTRYPOINT ["/opt/start-activity.sh"]
