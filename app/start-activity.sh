#!/bin/sh
exec java $JAVA_OPTS -jar -Djava.security.egd=file:/dev/./urandom /opt/app.jar