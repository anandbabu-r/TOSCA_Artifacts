package com.tosca.windowsapi;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import org.apache.log4j.Logger;

public class ProcessRunner_Main extends SystemEnvironment {

	static Logger logger = Logger.getLogger(ProcessRunner_Main.class.getName());

	/**
	 * @param args
	 * @throws IOException 
	 */	
	public static void main(String[] args) throws IOException {
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		OutputStream os = null;
		OutputStreamWriter osr = null;
		BufferedWriter br_writer = null;
		// TODO Auto-generated method stub
		String filetoexecute=args[1];
		if (args.length > 2)
		{
			//filetoexecute = 	filetoexecute + args[2];
		}
		
		String pwd=null ;
		if(args[0]!= null)
		pwd = args[0];
		try
		{
			String[] command = { "CMD", "/C", args[1],args[2],args[3],args[4] };
			
			ProcessBuilder probuilder = new ProcessBuilder(command);
			if(args.length > 0)
			{
				logger.debug("args[0] is" + args[0]);
			}
			probuilder.directory(new File(pwd));
			Process process = probuilder.start();
			// without the  block of code, the tomcat container wont start at all--start
			/*is = process.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);*/
			
			os = process.getOutputStream();
			osr =  new OutputStreamWriter(os);
			br_writer =  new BufferedWriter(osr);
			
			
			String line;
			logger.debug("Output of running %s is:\n" + 
					Arrays.toString(command));
			
			/*while ((line = br.readLine()) != null) {
				System.out.println(line);
			}*/
			/*while ((line = br_writer.) != null) {
				System.out.println(line);
			}*/
			
			
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

	}

}
