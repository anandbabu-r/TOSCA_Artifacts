/**
 * 
 */
package com.tosca.windowsapi;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * @author Kriss
 *
 */
public class SystemEnvironment {

	String pwd; //present working directory
	
	/**
	 * @return the pwd
	 */
	public String getpwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	
	 
	public void setpwd(String pwd) {
		this.pwd = pwd;
	}
	

	
	
	static Logger logger = Logger.getLogger(SystemEnvironment.class.getName());

	//setEnv() is used to set the environment in Windows; The functions are tested to work on windows; Its not tested in Linux.  
	void setEnv()
	{
		File fptr = null;
		try
		{
			
		pwd = System.getenv("TMP");
		
		if(pwd == null || pwd.equals(null))
		{
			pwd = System.getenv("TEMP");
			
		}
		if(pwd == null || pwd.equals(null))
		{
			// TODO check if "USERPROFILE" exists, if not, done do anything!
			String userprofilehome = System.getenv("USERPROFILE");
			if(userprofilehome != null )
			pwd = userprofilehome + "\\AppData\\Local\\Temp";
			else
				logger.error("None of TMP,TEMP,USERPROFILE classpath variables are set!!! So quitting without changing system");
			//System.setProperty("TMP", "value");
		}
		pwd = pwd+"\\TOSCAWINDOWSAPI";
		 fptr = new File(pwd);
		if( fptr.exists()) 
		{
			logger.debug("pwd exists");
		}
		else
		{
			fptr.mkdir();
			logger.debug("pwd created");
		}
		logger.debug("pwd is: " + pwd);
	}
		finally{
			if(fptr != null) {
				fptr = null;
			}
		}
}	
}
