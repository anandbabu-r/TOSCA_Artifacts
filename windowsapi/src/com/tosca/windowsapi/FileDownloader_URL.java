package com.tosca.windowsapi;

import java.io.BufferedOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;


/*
 * putFile is the main function; It takes the destination folder and the url to download as input; if the desination folder is not specified, then the temp directory is used to download the files 
 * input:C:\\TOSCA\\( or C:\\TOSCA)  http://en.wikipedia.org/wiki/Arahuay 
 * output:the url will be downloaded to the folder specified 
 */

public class FileDownloader_URL extends SystemEnvironment {
	static Logger logger = Logger.getLogger(FileDownloader_URL.class.getName());
	final int size = 1024;

	// do the low-level file downloading using the streams
	void fileUrl(String fAddress, String localFileName, String destinationDir) {
		OutputStream outStream = null;
		URLConnection uCon = null;
		InputStream is = null;
		try {
			URL Url;
			byte[] buf;
			int ByteRead, ByteWritten = 0;
			Url = new URL(fAddress);
			outStream = new BufferedOutputStream(new FileOutputStream(
					destinationDir + "\\" + localFileName));
			uCon = Url.openConnection();
			is = uCon.getInputStream();
			buf = new byte[size];
			while ((ByteRead = is.read(buf)) != -1) {
				outStream.write(buf, 0, ByteRead);
				ByteWritten += ByteRead;
			}
			logger.info("Downloaded Successfully. under directory " + destinationDir);
			logger.info("File name:\"" + localFileName + "\"\nNo ofbytes :"
					+ ByteWritten);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
				if (outStream != null)
					outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// find the localfilename and call the low-level function
	String fileDownload(String fAddress, String destinationDir) {

		int slashIndex = fAddress.lastIndexOf('/');
		int periodIndex = fAddress.lastIndexOf('.');

		// get the filename
		String fileName = fAddress.substring(slashIndex + 1);

		if (periodIndex >= 1 && slashIndex >= 0
				&& slashIndex < fAddress.length() - 1) {
			fileUrl(fAddress, fileName, destinationDir);
		} else {
			logger.warn("path or file name.");
		}
		return fileName;
	}

	public String putFile(String dest_dir, String url) {
		if (dest_dir == null || dest_dir.equals(null)) {
			logger.debug("dest_dir is null");
			setEnv();// use default destination
			dest_dir = pwd;
		}
		fileDownload(url, dest_dir);
		return fileDownload(url, dest_dir);
	}
}