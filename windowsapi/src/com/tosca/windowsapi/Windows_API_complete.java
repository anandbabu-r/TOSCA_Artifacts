package com.tosca.windowsapi;

import java.io.IOException;

public class Windows_API_complete {

	/**
	 * @param args
	 * @throws IOException 
	 */
/*	Sample input: folder_name url_download folder_underzipfile_which_containsthefile_to_be_executed(start with the exact folder and then use the slashes) file_to_be_executed
	apache7 http://www.apache.org/dist/tomcat/tomcat-7/v7.0.27/bin/apache-tomcat-7.0.27.zip bin startup.bat

	output:C:\Users\Kriss\AppData\Local\Temp\TOSCAWINDOWSAPI\apache7_2\apache-tomcat-7.0.27\ will be created (the name of the zip file is the folder name)
	then under that bin is set as present working directory
	and startup.bat is called
*/
 
	public boolean processzipfile(String foldername,String URL,String newpwd,String exec_fname) throws IOException {
		// TODO Auto-generated method stub
		FolderMaker tmpfolder = new FolderMaker();
		String pwd=tmpfolder.mkdir(foldername);
		FileDownloader_URL file_downloader = new FileDownloader_URL();
		String fname=file_downloader.putFile(pwd, URL);
		if(fname.contains(".zip"))
			System.out.println("Input is a zip file");
		Unzipper uzip = new Unzipper();
			String fullpath_of_zipfle = pwd + "\\" + fname;
		System.out.println("fullpath_of_zipfle is " + fullpath_of_zipfle + "and destinationdir is" + pwd);
		uzip.process(fullpath_of_zipfle, pwd);
		int periodIndex = fname.lastIndexOf('.');
		String folderName = fname.substring(0,periodIndex);
		System.out.println("folderName is " + folderName);
		ProcessRunner ps = new ProcessRunner();
		String base_folder = pwd+"\\"+folderName+"\\" + newpwd;
		//String tomcat_stup_script = pwd+"\\"+fileName+"\\bin\\startup.cmd";
		ps.runExecutable(exec_fname, base_folder);
		return true;

	}
	
//	sample input: textpad http://download.textpad.com/download/v54/txpeng542.exe
	//sample output: Downloaded Successfully. under directory C:\Users\Kriss\AppData\Local\Temp\TOSCAWINDOWSAPI\textpad_latest
	
	public boolean processexefile(String foldername,String URL) throws IOException {
		// TODO Auto-generated method stub
		FolderMaker tmpfolder = new FolderMaker();
		String pwd=tmpfolder.mkdir(foldername);
		FileDownloader_URL file_downloader = new FileDownloader_URL();
		String fname=file_downloader.putFile(pwd, URL);
		/*if(fname.contains(".zip"))
			System.out.println("Input is a zip file");
		Unzipper uzip = new Unzipper();
			String fullpath_of_zipfle = pwd + "\\" + fname;
		System.out.println("fullpath_of_zipfle is " + fullpath_of_zipfle + "and destinationdir is" + pwd);
		uzip.process(fullpath_of_zipfle, pwd);*/
		/*int periodIndex = fname.lastIndexOf('.');
		String fileName = fname.substring(0,periodIndex);
		System.out.println("filename is " + fileName);*/
		ProcessRunner ps = new ProcessRunner();
		//String base_folder = pwd+"\\"+fileName+"\\" + newpwd;
		//String tomcat_stup_script = pwd+"\\"+fileName+"\\bin\\startup.cmd";
		ps.runExecutable(fname, pwd);
		return true;

	}


}
