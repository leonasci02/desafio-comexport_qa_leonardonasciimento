package core.web;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import log.LogSetup;

public class ChromeNavegador {

	private ChromeDriver driver;
	static Logger logger = LogSetup.getLogger(ChromeNavegador.class);
	
	public ChromeNavegador( Boolean headless) {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = setupChromeBrowser(headless);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		logger.info("Chrome iniciado com sucesso.");
	}
	
	private ChromeOptions setupChromeBrowser(Boolean headless) {
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator);
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("safebrowsing.enabled", "true"); 
        chromePrefs.put("profile.default_content_setting_values.notifications", 2);
		
		// Configurando Opcoes de Navegador
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--window-size=1920,1080");
		options.addArguments("start-maximized"); 
		options.addArguments("--lang=pt-BR");
		options.addArguments("--incognito");
		options.addArguments("--ignore-certificate-errors");

		if (Boolean.TRUE.equals(headless)) {
			options.addArguments("--headless");
			options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			options.addArguments("--disable-gpu"); // applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--ignore-certificate-errors");
		}

		return options;

	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
