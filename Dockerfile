FROM tomcat:9.0
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the web files to the ROOT webapp directory
COPY index.jsp /usr/local/tomcat/webapps/ROOT/
COPY css/ /usr/local/tomcat/webapps/ROOT/css/
COPY js/ /usr/local/tomcat/webapps/ROOT/js/
COPY WEB-INF/ /usr/local/tomcat/webapps/ROOT/WEB-INF/

EXPOSE 8080
CMD ["catalina.sh", "run"]
