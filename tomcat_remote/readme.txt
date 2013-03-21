First i enabled on jmx by making a new file 'setenv.bat' under 
C:\TOSCA\apache-tomcat-7.0.25-windows-x86\apache-tomcat-7.0.25\bin
i set CATALINA_OPTS in that file

copied deployment descriptor C:\TOSCA\apache-tomcat-7.0.25-windows-x86\apache-tomcat-7.0.25\conf\Catalina\localhost\manager.xml


1. configure access to the manager application . for that
in tomcat-users.xml, this is added
<!--<user username="admin" password="admin" roles="manager-gui"/>-->
<user username="admin" password="admin" roles="manager-gui,manager-script"/>

//
We assume that the admin account is configured to manager-script on all the machines so that we can remotely issue commands  


to deploy using console the format is 
context path: /example
URL on Server: file:C:/TOSCA/tmp/example.war

to deploy using manager command  the steps are
1. The war file(example.war) need to be uploaded into appBase directory   
for e.g in anand's system it is C:\TOSCA\apache-tomcat-7.0.25-windows-x86\apache-tomcat-7.0.25\work\Catalina\localhost\manager

2. the url to deploy a resource is http://localhost:8080/manager/text/deploy?path=/example needs to be hit

http://localhost:8080/manager/text/undeploy?path=/example



To deploy a file remotely that already is in in the server the url is 
http://localhost:8080/manager/text/deploy?path=/footoo&war=file:C:/TOSCA/tmp/example.war

and the input is 
http://localhost:8080/ footoo C:/TOSCA/tmp/example.war

