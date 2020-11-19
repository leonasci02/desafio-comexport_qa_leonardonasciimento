package log;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogSetup {

	private LogSetup() {}
	
	public static Logger getLogger(Object objeto) {
		return getLogger(objeto.getClass());
	}
	
	public static Logger getLogger(Class<? extends Object> classTarget) {
		Logger logger = Logger.getLogger(classTarget);
		String configFile = caminhoDaPasta("log4j.properties");
		PropertyConfigurator.configure(configFile);
		return logger;
	}

	private static String caminhoDaPasta(String nomeDaPasta) {
		return System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
				+ "resources" + File.separator + "armazenador" + File.separator + nomeDaPasta;
	}

}
