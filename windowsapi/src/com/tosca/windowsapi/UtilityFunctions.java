package com.tosca.windowsapi;

import org.apache.log4j.Logger;

public class UtilityFunctions {
	static Logger logger = Logger.getLogger(UtilityFunctions.class.getName());
	
	// if the path is C:\\TOSCA\\check ,then the output will be an array with [0] -- C:\\TOSCA\\ and [1] -- check  
	public static String[] getpwdandfoldername(String folderName)
	{
		
		int endSlashIndex = folderName.lastIndexOf('\\');
		String pwd =  folderName.substring(0, endSlashIndex);
		logger.debug("pwd is " + pwd);
		logger.debug("foldername is " + folderName.substring(endSlashIndex));
		String array[] = new String[2];
		array[0] = pwd;
		array[1]=folderName.substring(endSlashIndex+1);
		return array;
		
	}
	//if the folder ends with \\ we remove it; for e.g. C:\\TOSCA\\ will be C:\\TOSCA 
	public static String FolderPathTrimmer(String folderToCreate)
	{
	if (folderToCreate.endsWith("\\")) {
		logger.debug("Ends with \\");
		int endSlashIndex = folderToCreate.lastIndexOf('\\');
		folderToCreate = folderToCreate.substring(0, endSlashIndex - 1);
		logger.debug("folderToCreate now is " + folderToCreate);
	}
	else
		logger.debug("not Ends with \\");
	return folderToCreate;

	}


	
}
