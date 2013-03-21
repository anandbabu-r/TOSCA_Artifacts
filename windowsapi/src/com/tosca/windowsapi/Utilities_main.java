package com.tosca.windowsapi;

import org.apache.log4j.Logger;

public class Utilities_main {

	static Logger logger = Logger.getLogger(Utilities_main.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String folderName = args[0];
		//First trim the ending \\ from the input
		
		if(args[0].contains("\\"))
		{
		logger.debug("Entering trimming and fetchpwd");
		String folderName = FolderPathTrimmer(args[0]);
		String foldertoCreate = fetchpwd(folderName);
		
		//fetch the pwd from the full path
		}
		
		


}
	public static String fetchpwd(String folderName)
	{
		
		int endSlashIndex = folderName.lastIndexOf('\\');
		String pwd =  folderName.substring(0, endSlashIndex-1);
		logger.debug("pwd is " + pwd);
		logger.debug("foldername is " + folderName.substring(endSlashIndex+1));
		return pwd;
	}
	
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
