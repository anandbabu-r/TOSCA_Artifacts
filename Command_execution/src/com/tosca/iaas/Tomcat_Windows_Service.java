package com.tosca.iaas;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

import org.apache.log4j.Logger;


public class Tomcat_Windows_Service {
	static Logger logger = Logger.getLogger(Tomcat_Windows_Service.class.getName());

	public void Start_Tomcat(String PathtoTomcatRootFolder) throws IOException{
		//System.out.println("Environment Variables are:");
		logger.debug("Environment Variables using log4j are:");
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		Map<String, String> variables = System.getenv();
		//String PathtoTomcatRootFolder="C:\\TOSCA\\apache-tomcat-7.0.25-windows-x86\\apache-tomcat-7.0.25\\bin";
		  
		for (Map.Entry<String, String> entry : variables.entrySet())  
		{  
		   String name = entry.getKey();  
		   String value = entry.getValue();  
		  // System.out.println(name + "=" + value);
		   logger.debug(name + "=" + value);
		}  
		try
		{
        String[] command = {"CMD", "/C", "startup.bat"};
        ProcessBuilder probuilder = new ProcessBuilder( command );
        probuilder.directory(new File(PathtoTomcatRootFolder));
        Process process = probuilder.start();
        is = process.getInputStream();
         isr = new InputStreamReader(is);
         br = new BufferedReader(isr);
        String line;
        logger.debug("Output of running using log4j %s is:\n" + 
                Arrays.toString(command));
        while ((line = br.readLine()) != null) {
           // System.out.println(line);
        	logger.debug(line);
        }

		}
		finally{
			if (is != null) {
				is.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (br != null) {
				br.close();
			}
			
		}
	}
	
	public void Stop_Tomcat() throws IOException
	{

        String[] command = {"CMD", "/C", "shutdown.bat"};
        ProcessBuilder probuilder = new ProcessBuilder( command );
        probuilder.directory(new File("C:\\TOSCA\\apache-tomcat-7.0.25-windows-x86\\apache-tomcat-7.0.25\\bin"));
        Process process = probuilder.start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        logger.debug("Output of running %s is:\n" + 
                Arrays.toString(command));
        while ((line = br.readLine()) != null) {
        	logger.debug(line);
        }

	}
	
}
