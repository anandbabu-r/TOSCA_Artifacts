package com.tosca.windowsapi;
import java.io.File;

import org.apache.log4j.*;

public class FolderMaker_Main {
	static Logger logger = Logger.getLogger(FolderMaker_Main.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Environment setup for creating home folder for the api
		File fptr = null;
		try
		{
		String defaultPath = System.getenv("TMP");
		logger.debug("defaultPath is: " + defaultPath);
		if(defaultPath.equals(null))
		{
			defaultPath = System.getenv("TEMP");
			
		}
		if(defaultPath.equals(null))
		{
			String userprofilehome = System.getenv("USERPROFILE");
			defaultPath = userprofilehome + "\\AppData\\Local\\Temp";
			//System.setProperty("TMP", "value");
		}
		defaultPath = defaultPath+"\\TOSCAWINDOWSAPI";
		 fptr = new File(defaultPath);
		if( fptr.exists()) 
		{
			logger.debug("defaultPath exists");
		}
		else
		{
			fptr.mkdir();
			logger.debug("defaultPath created");
		}
		
		String folderToCreate = defaultPath+"\\" + args[0];
		fptr = new File(folderToCreate);
		if(fptr.exists())
		{
			int i=1;
			while(true)
			{
				String foldercheck = folderToCreate + "(" + Integer.toString(i) + ")";
				fptr = new File(foldercheck);
				if(fptr.exists()) i++;
				else{
					folderToCreate = foldercheck;
					break;
				}
			}
		}
		fptr.mkdir();
		logger.info("Created folder: " + folderToCreate);
		
		/*if(fptr.mkdir()) 
			logger.info("Folder" + args[0] + "is created successfully under" + defaultPath );
		else
			logger.info("Problem creating the requested folder" );*/
		}		
		finally
		{
			if(fptr != null) {
				fptr = null;
			}
	
		}
		
	}

}
