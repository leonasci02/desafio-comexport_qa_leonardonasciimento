package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import log.LogSetup;

public class Utils {

	private Utils() {}
	
	private static Properties properties;
	private static Logger log = LogSetup.getLogger(Utils.class);

	public static String propNavegador() {
		return getProp("browser.name");
	}

	public static boolean propIsHeadless() {
		return (getProp("browser.mode.headless").contentEquals("True")) ? Boolean.TRUE :Boolean.FALSE;
	}
	
	public static String propBaseUrl() {
		return getProp("url.desafio.api");
	}
	
	public static String propBaseUrlWeb() {
		return getProp("url.desafio.web");
	}
	
	public static String propRequest() {
		return getProp("env.request");
	}	
	
	public static String propRequestAccept() {
		return getProp("env.request.accept");
	}
	
	public static String propRequestContent() {
		return getProp("env.request.content");
	}
	
	public static String getProp(String prop) {
		properties = getProp();
		return properties.getProperty(prop);
	}
	
	private static Properties getProp() {
		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(new FileInputStream(caminhoDaPasta("setup.properties")));
			} catch (IOException e) {
				log.error("Falha ao obter as propriedades de configuração, verifique se o arquivo existe.");
				e.printStackTrace();
			}
		}
		return properties;
	}

	private static String caminhoDaPasta(String nomeDaPasta) {
		return System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
				+ "resources" + File.separator + "armazenador" + File.separator + nomeDaPasta;
	}
	
}
