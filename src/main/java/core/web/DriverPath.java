package core.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import exceptions.NavegadorException;
import log.LogSetup;

public class DriverPath {

	static String sistema = System.getProperty("os.name").toLowerCase();
	private static final String chrome = "chrome";
	private static final String firefox = "FIREFOX";
	private static final String mensagem = "Navegador não encontrado.";
	static Logger logger = LogSetup.getLogger(DriverPath.class);
	static ChromeNavegador driverChrome;
	static FirefoxNavegador driverFirefox;
	
	private DriverPath() {}
	
	public static void informarPathDoDriver(String navegador,  WebDriver driver, Boolean headless){
		switch (sistemaOperacional()) {
		case "Windows":
			pathWindows(navegador, driver , headless);
			break;
		
		case "Mac":
			pathMac(navegador, driver , headless);
			break;
		
		case "Linux":
			pathLinux(navegador, driver , headless);
			break;
		default:
			throw new NavegadorException(navegador);
		}
	}
	
	public static WebDriver driverInicializado(String navegador) {
		switch (navegador) {
		case chrome:
			return driverChrome.getDriver();
		case firefox:
			return driverFirefox.getDriver();
		default:
			logger.error(mensagem);
			break;
		}
		return null;
	}
	
	private static void pathWindows(String navegador, WebDriver driver, Boolean headless) {
		switch (navegador) {
		case chrome:
			driverChrome = new ChromeNavegador(headless);
			break;
		case firefox:
			driverFirefox = new FirefoxNavegador(headless);
			break;
		default:
			logger.error(mensagem);
			break;
		}
	} 
	
	private static void pathMac(String navegador, WebDriver driver, Boolean headless) {
		switch (navegador) {
		case chrome:
			driverChrome = new ChromeNavegador(headless);
			break;
		case firefox:
			driverFirefox = new FirefoxNavegador(headless);
			break;
		default:
			logger.error(mensagem);
			break;
		}
	} 
	
	private static void pathLinux(String navegador, WebDriver driver, Boolean headless) {
		switch (navegador) {
		case chrome:
			driverChrome = new ChromeNavegador(headless);
			break;
		case firefox:
			driverFirefox = new FirefoxNavegador(headless);
			break;
		default:
			logger.error(mensagem);
			break;
		}
	} 
	
	private static String sistemaOperacional() {
		if (sistema.contains("windows")) {
			return "Windows";	
		}else if(sistema.contains("mac")) {
			return "Mac";
		}
		else {
			return "Linux";
		}
	}	
}
