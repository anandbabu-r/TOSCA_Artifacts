package com.tosca.windowsapi;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.log4j.Logger;
/*
 * runExecutable takes a filename and a path to the file as input and launch the process
 * For e.g startup.bat and C:\\TOSCA\\apache-tomcat-7.0.25-windows-x86\\apache-tomcat-7.0.25\\bin(or C:\\TOSCA\\apache-tomcat-7.0.25-windows-x86\\apache-tomcat-7.0.25\\bin\\) can be the input to launch startup.bat
 */

public class ProcessRunner  extends SystemEnvironment {

	static Logger logger = Logger.getLogger(ProcessRunner.class.getName());
	
	public boolean runExecutable(String fname,String path) throws IOException
	{
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String filetoexecute=fname;
		String pwd=null ;
		if(path != null)
		pwd = path;
		try
		{
			String[] command = { "CMD", "/C", filetoexecute };
			ProcessBuilder probuilder = new ProcessBuilder(command);	
			probuilder.directory(new File(pwd));
			Process process = probuilder.start();
			// without the  block of code, the tomcat container wont start at all--start
			is = process.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			String line;
			logger.debug("Output of running %s is:\n" + 
					Arrays.toString(command));
			
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
			}
			// without the  block of code, the tomcat container wont start at all--stop
			try {
				int exitValue = process.waitFor();
				logger.debug("\n\nExit Value is " + exitValue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

		
		return true;
	}
	
}
