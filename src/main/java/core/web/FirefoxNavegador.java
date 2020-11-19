package core.web;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;
import log.LogSetup;

public class FirefoxNavegador {

	private FirefoxDriver driver;
	static Logger logger = LogSetup.getLogger(FirefoxNavegador.class);
	
	public FirefoxNavegador(Boolean headless) {
		WebDriverManager.firefoxdriver().setup();
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		FirefoxOptions firefoxOptions = setupBrowser(headless);

		driver = new FirefoxDriver(firefoxOptions);
		logger.info("Firefox iniciado com sucesso.");
	}
	
	private FirefoxOptions setupBrowser(Boolean headless) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.closeWhenDone", true);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.useWindow", false);

		// Configuracoes das opcoes do perfil para inserir no navegador
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setProfile(profile);
		firefoxOptions.setHeadless(headless);
		return firefoxOptions;
	}

	public FirefoxDriver getDriver() {
		return driver;
	}



}
