FROM tomcat:9.0
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the web files to the ROOT webapp directory
COPY web/ /usr/local/tomcat/webapps/ROOT/
EXPOSE 8080
CMD ["catalina.sh", "run"]
