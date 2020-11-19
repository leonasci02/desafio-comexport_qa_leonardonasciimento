package core.web;

import org.openqa.selenium.WebDriver;

public class DriverWeb {

	private static WebDriver driver = null;
	private DriverWeb() {}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static WebDriver getDriver(String navegadorDeExecucao, Boolean executarSemInterfaceGrafica) {
		if (driver == null) {
			DriverPath.informarPathDoDriver(navegadorDeExecucao, driver, executarSemInterfaceGrafica);
			driver = DriverPath.driverInicializado(navegadorDeExecucao);
		}
		return driver;
	}

	public static void finalizarDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
