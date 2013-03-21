package com.tosca.iaas;

import java.io.*;
import java.sql.*;
import java.util.*;

public class UsePropertiesFile {
	
	public static String[] getUsernameandPassword() throws FileNotFoundException, IOException
	{
		String username_pwd[] = new String[2];
	     Properties prop = new Properties();
	     prop.load(new FileInputStream("data.properties"));
	     username_pwd[0] = prop.getProperty("username");
	     username_pwd[1] = prop.getProperty("password");
	     return username_pwd;
	}
	public final static void main(String[] args) throws Exception {
		String username_pwd[] =  getUsernameandPassword();
		System.out.println(username_pwd[0]);
	}

	/**
	 * @param pass the pass to set
	 */
	
}