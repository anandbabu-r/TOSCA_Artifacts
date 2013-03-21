package com.tosca.iaas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import sun.net.www.URLConnection;
import org.apache.log4j.Logger;




public class Tomcat_Remote_Admin {

	/**
	 * @param args
	 * @throws ClientProtocolException
	 * @throws IOException
	 */

	static Logger logger = Logger.getLogger(Tomcat_Remote_Admin.class.getName());

	// TODO additional parameter: URL warFileLocation
	public void deploy(String URL_tomcat,String contextpath) throws ClientProtocolException, IOException
	{
/*		 DefaultHttpClient httpclient = new DefaultHttpClient();
	        try {
	            httpclient.getCredentialsProvider().setCredentials(
	                    new AuthScope("localhost", 8080),
	                    new UsernamePasswordCredentials("admin", "admin"));

	            String urltohit= URL_tomcat+ "/manager/text/deploy?path=/" + contextpath;
	            //HttpGet httpget = new HttpGet("http://localhost:8080/manager/text/deploy?path=/example");
	            //HttpGet httpget = new HttpGet(urltohit);
	            HttpPut httpput = new HttpPut(urltohit);

	            // TODO use PUT request, place warFile into body of PUT request
	            URL warFileURL = new URL("file:C:/TOSCA/tmp/example.war");
	            InputStreamEntity inp = new  InputStreamEntity(warFileURL.openStream(), -1);
	            inp.setContentType("binary/octet-stream");
	            inp.setChunked(true);


	           // HttpEntity entity = new  InputStreamEntity(warFileURL.openStream(), 0);
//	            HttpPut put = new HttpPut(urltohit);
//	            put.setEntity(entity);
	            //logger.info("executing request" + httpget.getRequestLine());
	            //HttpResponse response = httpclient.execute(httpget);
	            //HttpEntity entity = response.getEntity();
	            ResponseHandler<String> responseHandler = new BasicResponseHandler();
	           // String responseBody = httpclient.execute(httpget, responseHandler);



	            logger.debug("----------------------------------------");
	            //logger.debug(responseBody);
	            logger.debug("----------------------------------------");
	            //System.out.println("----------------------------------------");
	            //System.out.println(response.getStatusLine());
	            //if (entity != null) {
	              //  System.out.println("Response content length: " + entity.getContentLength());
	            //}
	            //EntityUtils.consume(entity);
	        } finally {
	            // When HttpClient instance is no longer needed,
	            // shut down the connection manager to ensure
	            // immediate deallocation of all system resources
	            httpclient.getConnectionManager().shutdown();
	        }*/
		DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope("localhost", 8080),
                    new UsernamePasswordCredentials("admin", "admin"));

            String urltohit= URL_tomcat+ "/manager/text/deploy?path=/" + contextpath;
            //HttpGet httpget = new HttpGet("http://localhost:8080/manager/text/deploy?path=/example");
            HttpGet httpget = new HttpGet(urltohit);
            System.out.println("executing request" + httpget.getRequestLine());
            //
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
           String responseBody = httpclient.execute(httpget, responseHandler);
            //HttpResponse response = httpclient.execute(httpget);
            //response.getAllHeaders();
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            System.out.println("----------------------------------------");
        }
        finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }

	}

	public int deployfileonserver(String URL,String Contextpath, String pathtoWar) throws ClientProtocolException, IOException
	{
		// sample input: http://localhost:8080/ footoo C:/TOSCA/tmp/example.war

		 DefaultHttpClient httpclient = new DefaultHttpClient();
		 //UsePropertiesFile prop  = new UsePropertiesFile();
	        try {
		httpclient.getCredentialsProvider().setCredentials(
                new AuthScope("localhost", 8080),
                new UsernamePasswordCredentials("admin", "admin"));
				String urltohit=URL + "manager/text/deploy?path=/" + Contextpath + "&war=file:" +   pathtoWar + "&update=true";
				HttpGet httpget = new HttpGet(urltohit);
				logger.debug("executing request" + httpget.getRequestLine());
				ResponseHandler<String> responseHandler = new BasicResponseHandler();

	            String responseBody = httpclient.execute(httpget, responseHandler);

	            //logger.debug(prop.getUsernameandPassword());
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            logger.debug("----------------------------------------");
	            logger.debug(responseBody);
	            logger.debug("----------------------------------------");
	            return 1;
	        }
	        finally{
	        	// When HttpClient instance is no longer needed,
	            // shut down the connection manager to ensure
	            // immediate deallocation of all system resources
	            httpclient.getConnectionManager().shutdown();
	        }


	}
	// sample input: http://localhost:8080/
	public int listcurrentapps(String URL) throws ClientProtocolException, IOException
	{
		//http://localhost:8080/manager/text/list
		DefaultHttpClient httpclient = new DefaultHttpClient();
		 //UsePropertiesFile prop  = new UsePropertiesFile();
	        try {
		httpclient.getCredentialsProvider().setCredentials(
               new AuthScope("localhost", 8080),
               new UsernamePasswordCredentials("admin", "admin"));
				String urltohit=URL + "manager/text/list";
				HttpGet httpget = new HttpGet(urltohit);
				logger.info("executing request" + httpget.getRequestLine());
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
	            String responseBody = httpclient.execute(httpget, responseHandler);
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            //logger.debug(prop.getUsernameandPassword());
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            logger.debug("----------------------------------------");
	            logger.debug(responseBody);
	            logger.debug("----------------------------------------");
	            return 1;
	        }
	        finally{
	        	// When HttpClient instance is no longer needed,
	            // shut down the connection manager to ensure
	            // immediate deallocation of all system resources
	            httpclient.getConnectionManager().shutdown();
	        }


	}
	// sample input: http://localhost:8080/ footoo
	public int reloadapp(String URL, String Contextpath) throws ClientProtocolException, IOException
	{
		//http://localhost:8080/manager/text/reload?path=/footoo  input is  http://localhost:8080/ and footoo
		DefaultHttpClient httpclient = new DefaultHttpClient();
		 //UsePropertiesFile prop  = new UsePropertiesFile();
	        try {
		httpclient.getCredentialsProvider().setCredentials(
              new AuthScope("localhost", 8080),
              new UsernamePasswordCredentials("admin", "admin"));
				String urltohit=URL + "manager/text/reload?path=/" + Contextpath;
				HttpGet httpget = new HttpGet(urltohit);
				logger.info("executing request" + httpget.getRequestLine());
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
	            String responseBody = httpclient.execute(httpget, responseHandler);
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            //logger.debug(prop.getUsernameandPassword());
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            logger.debug("----------------------------------------");
	            logger.debug(responseBody);
	            logger.debug("----------------------------------------");
	            return 1;
	        }
	        finally{
	        	// When HttpClient instance is no longer needed,
	            // shut down the connection manager to ensure
	            // immediate deallocation of all system resources
	            httpclient.getConnectionManager().shutdown();
	        }

	}

	public int listOSandJVM(String URL) throws ClientProtocolException, IOException
	{
		//http://localhost:8080/manager/text/serverinfo inp is http://localhost:8080/
		DefaultHttpClient httpclient = new DefaultHttpClient();
		 //UsePropertiesFile prop  = new UsePropertiesFile();
	        try {
		httpclient.getCredentialsProvider().setCredentials(
               new AuthScope("localhost", 8080),
               new UsernamePasswordCredentials("admin", "admin"));
				String urltohit=URL + "manager/text/serverinfo";
				HttpGet httpget = new HttpGet(urltohit);
				logger.info("executing request" + httpget.getRequestLine());
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
	            String responseBody = httpclient.execute(httpget, responseHandler);
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            //logger.debug(prop.getUsernameandPassword());
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            logger.debug("----------------------------------------");
	            logger.debug(responseBody);
	            logger.debug("----------------------------------------");
	            return 1;
	        }
	        finally{
	        	// When HttpClient instance is no longer needed,
	            // shut down the connection manager to ensure
	            // immediate deallocation of all system resources
	            httpclient.getConnectionManager().shutdown();
	        }


	}
	public int listSessionInfo(String URL,String Context) throws ClientProtocolException, IOException
	{
		//http://localhost:8080/manager/text/sessions?path=/examples inp is http://localhost:8080/ and examples
		DefaultHttpClient httpclient = new DefaultHttpClient();
		 //UsePropertiesFile prop  = new UsePropertiesFile();
	        try {
		httpclient.getCredentialsProvider().setCredentials(
               new AuthScope("localhost", 8080),
               new UsernamePasswordCredentials("admin", "admin"));
				String urltohit=URL + "manager/text/sessions?path=/" + Context;
				HttpGet httpget = new HttpGet(urltohit);
				logger.info("executing request" + httpget.getRequestLine());
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
	            String responseBody = httpclient.execute(httpget, responseHandler);
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            //logger.debug(prop.getUsernameandPassword());
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            logger.debug("----------------------------------------");
	            logger.debug(responseBody);
	            logger.debug("----------------------------------------");
	            return 1;
	        }
	        finally{
	        	// When HttpClient instance is no longer needed,
	            // shut down the connection manager to ensure
	            // immediate deallocation of all system resources
	            httpclient.getConnectionManager().shutdown();
	        }


	}
	public int startApplication(String URL,String Context) throws ClientProtocolException, IOException
	{


		//http://localhost:8080/manager/text/start?path=/examples inp is http://localhost:8080/ and examples
		DefaultHttpClient httpclient = new DefaultHttpClient();
		 //UsePropertiesFile prop  = new UsePropertiesFile();
	        try {
		httpclient.getCredentialsProvider().setCredentials(
               new AuthScope("localhost", 8080),
               new UsernamePasswordCredentials("admin", "admin"));
				String urltohit=URL + "manager/text/start?path=/" + Context;
				HttpGet httpget = new HttpGet(urltohit);
				logger.info("executing request" + httpget.getRequestLine());
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
	            String responseBody = httpclient.execute(httpget, responseHandler);
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            //logger.debug(prop.getUsernameandPassword());
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            logger.debug("----------------------------------------");
	            logger.debug(responseBody);
	            logger.debug("----------------------------------------");
	            return 1;
	        }
	        finally{
	        	// When HttpClient instance is no longer needed,
	            // shut down the connection manager to ensure
	            // immediate deallocation of all system resources
	            httpclient.getConnectionManager().shutdown();
	        }


	}

	public int stopApplication(String URL,String Context) throws ClientProtocolException, IOException
	{
		//http://localhost:8080/manager/text/stop?path=/examples inp is http://localhost:8080/ and examples
		DefaultHttpClient httpclient = new DefaultHttpClient();
		 //UsePropertiesFile prop  = new UsePropertiesFile();
	        try {
		httpclient.getCredentialsProvider().setCredentials(
               new AuthScope("localhost", 8080),
               new UsernamePasswordCredentials("admin", "admin"));
				String urltohit=URL + "manager/text/stop?path=/" + Context;
				HttpGet httpget = new HttpGet(urltohit);
				logger.info("executing request" + httpget.getRequestLine());
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
	            String responseBody = httpclient.execute(httpget, responseHandler);
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            //logger.debug(prop.getUsernameandPassword());
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            logger.debug("----------------------------------------");
	            logger.debug(responseBody);
	            logger.debug("----------------------------------------");
	            return 1;
	        }
	        finally{
	        	// When HttpClient instance is no longer needed,
	            // shut down the connection manager to ensure
	            // immediate deallocation of all system resources
	            httpclient.getConnectionManager().shutdown();
	        }


	}

	public int UndeployApplication(String URL,String Context) throws ClientProtocolException, IOException
	{
		//http://localhost:8080/manager/text/undeploy?path=/examples  inp is http://localhost:8080/ and examples
		DefaultHttpClient httpclient = new DefaultHttpClient();
		 //UsePropertiesFile prop  = new UsePropertiesFile();
	        try {
		httpclient.getCredentialsProvider().setCredentials(
               new AuthScope("localhost", 8080),
               new UsernamePasswordCredentials("admin", "admin"));
				String urltohit=URL + "manager/text/undeploy?path=/" + Context;
				HttpGet httpget = new HttpGet(urltohit);
				logger.info("executing request" + httpget.getRequestLine());
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
	            String responseBody = httpclient.execute(httpget, responseHandler);
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            //logger.debug(prop.getUsernameandPassword());
	            //HttpResponse response = httpclient.execute(httpget);
	            //logger.debug(response.getStatusLine());
	            logger.debug("----------------------------------------");
	            logger.debug(responseBody);
	            logger.debug("----------------------------------------");
	            return 1;
	        }
	        finally{
	        	// When HttpClient instance is no longer needed,
	            // shut down the connection manager to ensure
	            // immediate deallocation of all system resources
	            httpclient.getConnectionManager().shutdown();
	        }


	}











}

