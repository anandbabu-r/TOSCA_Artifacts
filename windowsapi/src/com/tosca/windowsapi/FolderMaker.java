package com.tosca.windowsapi;

import java.io.File;


import org.apache.log4j.Logger;



/*
 * Example usage for this class:
 *  input: check
 *  output: It will create the folder under %TMP%TOSCAWINDOWSAPI
 *  if check is already present then check(1) will be created.
 *  The created folder's full path will be returned to the user

 *  input:full path C:\\TOSCA\\anand\\ and C:\\TOSCA\\anand\\
 *  output: It will create the folder anand under C:\\TOSCA\\    
 */


public class FolderMaker extends SystemEnvironment {

	static Logger logger = Logger.getLogger(FolderMaker.class.getName());
	
	
		// String pwd;
	/**
	 * @return the pwd
	 */
	/*
	 * public String getpwd() { return pwd; }
	 *//**
	 * @param pwd
	 *            the pwd to set
	 */
	/*
	 * public void setpwd(String pwd) { this.pwd = pwd; } void setEnv() { File
	 * fptr = null; try {
	 * 
	 * pwd = System.getenv("TMP"); logger.debug("pwd is: " + pwd);
	 * if(pwd.equals(null)) { pwd = System.getenv("TEMP");
	 * 
	 * } if(pwd.equals(null)) { String userprofilehome =
	 * System.getenv("USERPROFILE"); pwd = userprofilehome +
	 * "\\AppData\\Local\\Temp"; //System.setProperty("TMP", "value"); } pwd =
	 * pwd+"\\TOSCAWINDOWSAPI"; fptr = new File(pwd); if( fptr.exists()) {
	 * logger.debug("pwd exists"); } else { fptr.mkdir();
	 * logger.debug("pwd created"); } } finally{ if(fptr != null) { fptr = null;
	 * } } }
	 */public String mkdir(String folderToCreate) {
		 
		 // check if the input is an absolute path; for e.g. if its like C:\\TOSCA\\check or C:\\TOSCA\\check\\
		 
		 if(folderToCreate.contains("\\"))
			{
			logger.debug("Entering trimming and fetchpwd");
			//we trim the ending so that there are no \\ at the end of the folder
			folderToCreate=UtilityFunctions.FolderPathTrimmer(folderToCreate);
			//here 1. we set the pwd which comes in tmparray[0] and then we set the folder to create in folderToCreate
			String tmparray[] =  UtilityFunctions.getpwdandfoldername(folderToCreate);
			setpwd(tmparray[0]);
			folderToCreate = tmparray[1];
			}
		 //if the user used a relative path, then pwd would be null 
		if (pwd == null || pwd.equals(null)) {
			logger.debug("pwd is null");
			// here we set a temp path as pwd
			setEnv();
		}
		logger.debug("pwd:" + pwd + ":");
		folderToCreate = pwd + "\\" + folderToCreate;
		logger.debug("folderToCreate is" + folderToCreate);
		File fptr = new File(folderToCreate);
		if (fptr.exists()) {
			int i = 1;
			while (true) {
				String foldercheck = folderToCreate + "(" + Integer.toString(i)
						+ ")";
				fptr = new File(foldercheck);
				if (fptr.exists())
					i++;
				else {
					folderToCreate = foldercheck;
					break;
				}
			}
		}
		if (fptr.mkdir())
			return folderToCreate;
		else
			return "error";
		// logger.info("Created folder: " + folderToCreate);

	}

}
