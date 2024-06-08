FROM tomcat:latest
LABEL maintainer="Marian Cap"
ADD BankingSystem-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
