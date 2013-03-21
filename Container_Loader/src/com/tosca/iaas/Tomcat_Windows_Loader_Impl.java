package com.tosca.iaas;

import org.apache.catalina.startup.Bootstrap;

public class Tomcat_Windows_Loader_Impl {
	//Bootstrap bootstrap;
	
	public int startTomcat(String pathToTomcatRoot)
	{
	/*	Bootstrap bootstrap=new Bootstrap();
		bootstrap.setCatalinaHome("c:/TOSCA/apache-tomcat-7.0.25-windows-x86/apache-tomcat-7.0.25/");
		bootstrap.setCatalinaBase("c:/TOSCA/apache-tomcat-7.0.25-windows-x86/apache-tomcat-7.0.25/");
		System.out.println("Catalina updated home now is  " + bootstrap.getCatalinaHome());
		System.out.println("Catalina base now is changed to  " + bootstrap.getCatalinaBase());
try {
			bootstrap.start();
			System.out.println("Started Again");
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		try {
			Thread.sleep(600000);
			System.out.println("Sleeping!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
//*/	
		//String pathToTomcatRoot="c:/TOSCA/apache-tomcat-7.0.25-windows-x86/apache-tomcat-7.0.25/";
		Tomcat.INSTANCE.setPathToTomcatRoot(pathToTomcatRoot);
		return (Tomcat.INSTANCE.start());
		}
	
		public int stopTomcat()
	{
			/*System.out.println("bootstrap3");
			Bootstrap bootstrap=new Bootstrap();
	//	bootstrap.setCatalinaHome("c:/TOSCA/apache-tomcat-7.0.25-windows-x86/apache-tomcat-7.0.25/");
			bootstrap.setCatalinaHome("c:/TOSCA/apache-tomcat-7.0.25-windows-x86/apache-tomcat-7.0.25/");
			bootstrap.setCatalinaBase("c:/TOSCA/apache-tomcat-7.0.25-windows-x86/apache-tomcat-7.0.25/");
			System.out.println("Catalina home now is  " + bootstrap.getCatalinaHome());
			System.out.println("Catalina base now is changed to  " + bootstrap.getCatalinaBase());
	try {
		
		if (bootstrap == null) {
			System.out.println("Bootstrap is null");
		}
		else{
			System.out.println("Bootstrap is not null");
		System.out.println("Going to stop");
	//	bootstrap.start(); //javax.management.InstanceAlreadyExistsException: Catalina:type=ServerClassLoader,name=common

		bootstrap.stop();
		return 0;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return -1;
	}*/
			return(Tomcat.INSTANCE.stop());
}
}