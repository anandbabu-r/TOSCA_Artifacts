
this project is to start tomcat using windows native startup scripts. the corresponding carbon project is Tomcat_Windows_Command

The class Tomcat_Windows_Service contains Start and stop tomcat webservice methods
 
 The class Tomcat_start is the main class. IT comes with a common launch profile which contains the program argument for this class.
 
 here the argument is a path to the bin folder of the tomcat container
 e.g: in Anand's machine it is "C:\\TOSCA\\apache-tomcat-7.0.25-windows-x86\\apache-tomcat-7.0.25\\bin". Configure for your machine accordingly this value