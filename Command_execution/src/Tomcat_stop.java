import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.log4j.Logger;


public class Tomcat_stop {

	static Logger logger = Logger.getLogger(Tomcat_stop.class.getName());
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*try {
			Process pb = new ProcessBuilder(  "cmd" ,  "/ c" ,  "dir"  ).start();
			 InputStream is = pb.getInputStream();
		       InputStreamReader isr = new InputStreamReader(is);
		       BufferedReader br = new BufferedReader(isr);
		       String line;
		       while ((line = br.readLine()) != null) {
			         System.out.println("Output is" + line);}
		}catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
        String[] command = {"CMD", "/C", "shutdown.bat"};
        ProcessBuilder probuilder = new ProcessBuilder( command );
        probuilder.directory(new File("C:\\TOSCA\\apache-tomcat-7.0.25-windows-x86\\apache-tomcat-7.0.25\\bin"));
        Process process = probuilder.start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        logger.debug("Output of running %s is:\n" +
                Arrays.toString(command));
        while ((line = br.readLine()) != null) {
        	logger.debug(line);
        }
        try {
            int exitValue = process.waitFor();
            logger.debug("\n\nExit Value is " + exitValue);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}

}
