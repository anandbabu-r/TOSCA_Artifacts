import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.tosca.iaas.Tomcat_Windows_Service;

public class Tomcat_start {

	/**
	 * @param args
	 * @throws IOException
	 */
	static Logger logger = Logger.getLogger(Tomcat_start.class.getName());
	public static void main(String[] args) throws IOException {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			
			String[] command = { "CMD", "/C", "startup.bat" };
			String catalina = System.getenv("CATALINA_HOME");
			logger.debug("catalina is:" + catalina);
			ProcessBuilder probuilder = new ProcessBuilder(command);
			String PathtoTomcatRootFolder;
			if(args.length >0)
				PathtoTomcatRootFolder= args[0];
			PathtoTomcatRootFolder= "C:\\TOSCA\\apache-tomcat-7.0.25-windows-x86\\apache-tomcat-7.0.25\\bin";
			//probuilder.directory(new File("C:\\TOSCA\\apache-tomcat-7.0.25-windows-x86\\apache-tomcat-7.0.25\\bin"));
			probuilder.directory(new File("C:\\TOSCA\\apache-tomcat-7.0.25-windows-x86\\apache-tomcat-7.0.25\\bin"));
			logger.debug("args[0] is" + args[0]);
			//probuilder.directory(new File(PathtoTomcatRootFolder));
			Process process = probuilder.start();
			// without the  block of code, the tomcat container wont start at all--start
			
			is = process.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			String line;
			logger.debug("Output of running %s is:\n" + 
					Arrays.toString(command));
			
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
			}
			// without the  block of code, the tomcat container wont start at all--stop
			try {
				int exitValue = process.waitFor();
				logger.debug("\n\nExit Value is " + exitValue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		finally {
			// release all allocated system resources
			if (is != null) {
				is.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (br != null) {
				br.close();
			}
		}

	}

}
