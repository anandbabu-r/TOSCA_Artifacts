package com.tosca.iaas;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpAuthenciation {
	static Logger logger = Logger.getLogger(HttpAuthenciation.class.getName());
    public static void main(String[] args) throws Exception {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        /*try {
            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope("localhost", 8080),
                    new UsernamePasswordCredentials("admin", "admin"));
            
            String urltohit= args[0]+ "/manager/text/deploy?path=/" + args[1];
            //HttpGet httpget = new HttpGet("http://localhost:8080/manager/text/deploy?path=/example");
            HttpGet httpget = new HttpGet(urltohit);
            System.out.println("executing request" + httpget.getRequestLine());
            //HttpResponse response = httpclient.execute(httpget);
            //HttpEntity entity = response.getEntity();
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
           String responseBody = httpclient.execute(httpget, responseHandler);
            HttpResponse response = httpclient.execute(httpget); 
            response.getAllHeaders();
            
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            System.out.println("----------------------------------------");
            
            System.out.println(responseBody);
            //System.out.println("----------------------------------------");
            //System.out.println(response.getStatusLine());
            //if (entity != null) {
              //  System.out.println("Response content length: " + entity.getContentLength());
            //}
            //EntityUtils.consume(entity);
            
            String userprofilehome = System.getenv("CLASSPATH_bkp");
            
            System.out.println("CLASSPATH_bkp -----------" + userprofilehome);
            
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }*/
        try {
            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope("localhost", 8080),
                    new UsernamePasswordCredentials("admin", "admin"));
            
            String urltohit= "http://localhost:8080/" + "/manager/text/deploy?path=/" + "example";
            //HttpGet httpget = new HttpGet("http://localhost:8080/manager/text/deploy?path=/example");
            //HttpGet httpget = new HttpGet(urltohit);
            HttpPut httpput = new HttpPut(urltohit);
            
            // TODO use PUT request, place warFile into body of PUT request
            URL warFileURL = new URL("file:C:/TOSCA/tmp/example.war");
            InputStreamEntity inp = new  InputStreamEntity(warFileURL.openStream(), -1);
            inp.setContentType("binary/octet-stream");
            inp.setChunked(true);
            //HttpEntity entity = new  InputStreamEntity(warFileURL.openStream(), -1);
            
            
            HttpEntity entity = inp;
            
//            HttpPut put = new HttpPut(urltohit);
//            put.setEntity(entity);
            httpput.setEntity(entity);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpput, responseHandler);
              
            //HttpResponse response = httpclient.execute(httpget);
            //HttpEntity entity = response.getEntity();                
            
            logger.debug("----------------------------------------");
            logger.debug(responseBody);
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
        }

    }

}
