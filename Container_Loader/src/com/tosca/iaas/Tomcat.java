package com.tosca.iaas;

import org.apache.catalina.startup.Bootstrap;
import org.apache.log4j.Logger;
import org.apache.log4j.*;

public class Tomcat {
	static Logger logger = Logger.getLogger(Tomcat.class.getName());
	Bootstrap bootstrap;
	String pathToTomcatRoot;
	// singleton
	public static Tomcat INSTANCE = new Tomcat();
	private Tomcat(){};
	
	public int start() {
		if(bootstrap == null)
		bootstrap=new Bootstrap();
		else 
			logger.debug("Bootstrap is not null");
		bootstrap.setCatalinaHome(pathToTomcatRoot);
		bootstrap.setCatalinaBase(pathToTomcatRoot);
		logger.debug("Catalina updated home using singleton now is  " + bootstrap.getCatalinaHome());
		logger.debug("Catalina base now is changed to  " + bootstrap.getCatalinaBase());
try {
	System.out.println("Calling destroy before starting");
	bootstrap.destroy();
			bootstrap.start();
			
			logger.debug("Started using singleton ");
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return -1;
	}
	
	public int stop() {
		try {
			if (bootstrap == null) {
				logger.debug("Bootstrap is null");
			}
			else{
				logger.debug("Bootstrap is not null");
				logger.debug("Going to stopserver");
		//	bootstrap.start(); //javax.management.InstanceAlreadyExistsException: Catalina:type=ServerClassLoader,name=common

			bootstrap.stopServer();
			return 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public void setPathToTomcatRoot(String path) {
		pathToTomcatRoot = path;
	}
	
	public String getPathToTomcatRoot() {
		return pathToTomcatRoot;
	}
}
