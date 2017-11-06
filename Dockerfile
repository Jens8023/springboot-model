# 网关环境
#FROM 10.2.23.3/wxyx_dev/gradle-oracle:latest
FROM 10.2.23.3/wxyx_dev/gradle-java:gradle_only
USER root

RUN mkdir /project
WORKDIR /project
ADD . /project
RUN rm -rf build

RUN gradle build -x test
RUN IFS=$'\n'
RUN mv build/libs/*.jar /app.jar

ENV DAE_NETWORK='port'
RUN chmod a+x /project/dce-app-entrypoint
ENTRYPOINT ["/project/dce-app-entrypoint"]
CMD ["java","-jar","-Dspring.profiles.active=dev","/app.jar"]



# 本地环境
#FROM 10.2.23.3/wxyx_dev/gradle-oracle:latest
FROM 10.2.23.3/wxyx_dev/gradle-java:gradle_only
USER root

RUN mkdir /project
WORKDIR /project
ADD . /project
RUN rm -rf build

RUN gradle build -x test
RUN IFS=$'\n'
RUN mv build/libs/*.jar /app.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/app.jar"]

EXPOSE 8090