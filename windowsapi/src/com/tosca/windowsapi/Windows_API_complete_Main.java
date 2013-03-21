package com.tosca.windowsapi;

import java.io.IOException;

public class Windows_API_complete_Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FolderMaker tmpfolder = new FolderMaker();
		String pwd=tmpfolder.mkdir(args[0]);
		FileDownloader_URL file_downloader = new FileDownloader_URL();
		String fname=file_downloader.putFile(pwd, args[1]);
		String folderName = null;
		if(fname.contains(".zip"))
		{
			System.out.println("Input is a zip file");
		Unzipper uzip = new Unzipper();
		String fullpath_of_zipfle = pwd + "\\" + fname;
		System.out.println("fullpath_of_zipfle is " + fullpath_of_zipfle + "and destinationdir is" + pwd);
		uzip.process(fullpath_of_zipfle, pwd);
		int periodIndex = fname.lastIndexOf('.');
		 folderName = fname.substring(0,periodIndex);
		System.out.println("folderName is " + folderName);
		}
		if(fname.contains(".exe"))
		{
			ProcessRunner ps = new ProcessRunner();
			ps.runExecutable(fname, pwd);
		}
		else
		{		
		ProcessRunner ps = new ProcessRunner();
		String base_folder = pwd+"\\"+folderName+"\\" + args[2];
		UtilityFunctions.FolderPathTrimmer(base_folder);
		//String tomcat_stup_script = pwd+"\\"+fileName+"\\bin\\startup.cmd";
		ps.runExecutable(args[3], base_folder);
		}

	}

}
