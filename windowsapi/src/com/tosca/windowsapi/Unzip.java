package com.tosca.windowsapi;

	import java.io.*;
	import java.util.*;
	import java.util.zip.*;
	public class Unzip {
	public static final void copyInputStream(InputStream in, OutputStream out)
	throws IOException
	{
	byte[] buffer = new byte[1024];
	int len;
	while((len = in.read(buffer)) >= 0)
	out.write(buffer, 0, len);
	in.close();
	out.close();
	}
	public static final void main(String[] args) {
	Enumeration entries;
	String pwd = null;
	ZipFile zipFile;
	if(args.length != 1) {
	System.err.println("Usage: Unzip zipfile");
	return;
	}
	try {
	zipFile = new ZipFile(args[0]);
	entries = zipFile.entries();
	while(entries.hasMoreElements()) {
	ZipEntry entry = (ZipEntry)entries.nextElement();
	if(entry.isDirectory()) {
	// Assume directories are stored parents first then children.
	System.err.println("Extracting directory: " + entry.getName());
	// This is not robust, just for demonstration purposes.
	pwd = "C:\\Users\\Kriss\\AppData\\Local\\Temp\\TOSCAWINDOWSAPI\\apache(2)\\" + entry.getName();
	System.out.println("pwd is  " + pwd);
	
	(new File(pwd)).mkdir();
	continue;
	}
	System.err.println("Extracting file: " + entry.getName());
	String curfile = "C:\\Users\\Kriss\\AppData\\Local\\Temp\\TOSCAWINDOWSAPI\\apache(2)\\" + entry.getName();
	
	copyInputStream(zipFile.getInputStream(entry),
	new BufferedOutputStream(new FileOutputStream(curfile)));
	}
	zipFile.close();
	} catch (IOException ioe) {
	System.err.println("Unhandled exception:");
	ioe.printStackTrace();
	return;
	}
	}
	}