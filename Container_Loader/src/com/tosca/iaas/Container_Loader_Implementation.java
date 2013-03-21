package com.tosca.iaas;
import org.apache.catalina.startup.Bootstrap;
import org.apache.log4j.*;
import org.apache.log4j.Logger;


public class Container_Loader_Implementation {
	 static Logger logger = Logger.getLogger(Container_Loader_Implementation.class.getName()); 
public static void main(String[] args)
{
	
	Bootstrap bootstrap=new Bootstrap();
	bootstrap.setCatalinaHome(args[0]);
	try {
		bootstrap.start();
		logger.debug("Started!");
		logger.debug("Catalina base now is  " + bootstrap.getCatalinaBase());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		Thread.sleep(6000000);
		logger.debug("Sleeping!");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		logger.debug("Going to stop");
		bootstrap.stop();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
