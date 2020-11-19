package core.web;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import log.LogSetup;

public class WebBaseTest {

	private JavascriptExecutor executor;
	private Logger logger = LogSetup.getLogger(WebBaseTest.class);

	long TIMEOUT = 40;

	public WebDriver getDriver() {
		return DriverWeb.getDriver();
	}

	/*
	 * *********************************
	 * 
	 * elementos Web
	 * 
	 ***********************************/
	public WebElement procurar(String cssSelector) {
		return procurar(By.cssSelector(cssSelector));
	}

	protected WebElement procurar(By element) {
		try {
			logger.info("Realizando localizacao do elemento web.");
			return getDriver().findElement(element);
		} catch (NoSuchElementException e) {
			logger.error("Nao foi possivel localizar o elemento, verifique o parametro deidentificacao.");
			return null;
		}
	}

	public List<WebElement> procurarElementos(By element) {
		try {
			logger.info("Realizando localizacao de varios elementos web.");
			return getDriver().findElements(element);
		} catch (NoSuchElementException e) {
			logger.error("Nao foi possivel localizar os elemento, verifique o Selector informado.");
		}
		return null;
	}

	private Select procurarComboBox(By element) {
		WebElement webElement = esperarPresencaDoElement(element);
		logger.info("Encontrando combo box de opcoes.");
		return new Select(webElement);
	}

	public String getCssValue(By element, String elementCss) {
		logger.info("Obtendo valor css do elemento web.");
		return procurar(element).getCssValue(elementCss);
	}

	public String getAttributeValue(By element) {
		return getAttributeValue(procurar(element));
	}

	public String getAttributeValue(WebElement element) {
		return getAttribute(element, "value", true);
	}

	public String getAttribute(WebElement element, String attribute) {
		return getAttribute(element, attribute, true);
	}

	public String getAttribute(WebElement element, String attribute, boolean printLog) {
		if (printLog) {
			logger.info(String.format("Obtendo valor [%s] do elemento web. [%s]", attribute,
					element.getAttribute(attribute)));
		}
		return element.getAttribute(attribute);
	}

	public void elementoExiste(WebElement element) {
		logger.info("Validando existencia de um elemento web.");
		if (element.isDisplayed()) {
			logger.info("Elemento encontrado com sucesso");
		} else {
			esperarPresencaDoElement(element);
		}
	}

	public void elementoExiste(By element) {
		elementoExiste(procurar(element));
	}

	public boolean elementoAtivo(By element) {
		WebElement e = procurar(element);
		return elementoAtivo(e);
	}

	public boolean elementoAtivo(WebElement element) {
		logger.info("Verificando se elemento esta haabilitado.");
		return element.isEnabled();
	}

	public void elementoEstaSelecionado(WebElement element) {
		logger.info("Verificando se elemento esta selecionado.");
		assertTrue(element.isSelected());
	}

	public void escrever(By element, String textContent) {
		WebElement waitPresenceOfElement = esperarPresencaDoElement(element);
		escrever(waitPresenceOfElement, textContent);
	}

	public void escrever(WebElement element, String text) {
		elementoExiste(element);
		elementoAtivo(element);
		limpar(element);
		element.sendKeys(text);
	}

	public void escreverJavascript(By elemento, String texto) {
		logger.info(
				String.format("Realizar a ação do método [escreverJavascript] no elemento [%s] e texto [%s].", elemento, texto));
		JavascriptExecutor executor = (JavascriptExecutor) DriverWeb.getDriver();
		executor.executeScript("arguments[0].value=\"" + texto + "\";", DriverWeb.getDriver().findElement(elemento));
	}

	public void escreverUmaLetraPorVez(By elemento, String texto) {
		logger.info(String.format("Realizar a ação do método [escreverUmaLetraPorVez] no elemento [%s] e texto [%s].",
				elemento, texto));
		DriverWeb.getDriver().findElement(elemento).clear();
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			String s = new StringBuilder().append(c).toString();
			DriverWeb.getDriver().findElement(elemento).sendKeys(s);
		}

	}

	public void limpar(WebElement element) {
		logger.info("Limpando o conteudo presente em um componente web.");
		element.clear();
	}

	public void limpar(By elemento) {
		logger.info("Limpando o conteudo presente em um componente web.");
		getDriver().findElement(elemento).clear();
	}

	public void refreshPage() {
		getDriver().navigate().refresh();
		logger.info("Recarregando a pagina.");
	}

	public String obtemTexto(WebElement element) {
		return obtemTexto(element, true);
	}

	public String obtemTexto(WebElement element, boolean showLog) {
		if (showLog) {
			logger.info(String.format("Obtendo texto do elemento web. [%s]", element.getText()));
		}
		return element.getText();
	}

	public String obtemTexto(By element) {
		return obtemTexto(procurar(element));
	}

	public WebElement clicar(WebElement element) {
		try {
			esperarSerClicave(element);
			element.click();
		} catch (Exception e) {
			clickJs(element);
		}
		return element;
	}

	public void clicar(By element) {
		WebElement e = esperarPresencaDoElement(element);
		esperarPresencaDoElemento(element);
		clicar(e);
	}

	public void clickJs(WebElement element) {
		try {
			executor.executeScript("arguments[0].click();", element);
			logger.info("Clicando num componente usando script JS.");
		} catch (NoSuchElementException e) {
			logger.error("Falha ao tentar clicar usando script JS.");
		}

	}

	public void clicarElementos(List<WebElement> elements) {
		for (WebElement e : elements) {
			logger.info("Realizando cliques em uma lista de diversos elementos.");
			clicar(e);
		}
	}

	public void openUrl(String url) {
		getDriver().get(url);
		logger.info(String.format("Navegando para URL [%s]", url));
	}

	public void navigateTo(String url) {
		getDriver().navigate().to(url);
		logger.info(String.format("Navegando para URL [%s]", url));
	}

	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

	public void selectComboBox(By element, String value) {
		Select combo = procurarComboBox(element);
		try {
			combo.selectByValue(value);
			logger.info(String.format("Escolhendo o valor [%s] no elemento combo box.", value));
		} catch (Exception e) {
			combo.selectByIndex(Integer.parseInt(value));
			logger.error(String.format("Escolhendo o valor [%s] no elemento combo  box.", value));
		}
	}

	public void selectComboBox(WebElement element, String value) {
		Select combo = new Select(element);
		try {
			combo.selectByValue(value);
			logger.info(String.format("Escolhendo o valor [%s] no elemento combo box.", value));
		} catch (Exception e) {
			combo.selectByIndex(Integer.parseInt(value));
			logger.error(String.format("Escolhendo o valor [%s] no elemento combo box.", value));
		}
	}

	public void scrollJavaScript(int scroll) {
		logger.info(String.format("Realizar a ação do método [scrollJavaScript] com a quantidae %d. de pixel", scroll));
		JavascriptExecutor jse = (JavascriptExecutor) DriverWeb.getDriver();
		jse.executeScript("window.scrollBy(0," + scroll + ")", "");
	}

	public void esperarSerClicavel(By elemento) {
		logger.info(String.format(
				"Realizar a ação do método [esperarElementoSerClicavel] com elemento [%s] por %d segundos", elemento,
				TIMEOUT));
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}

	public WebElement esperarSerClicave(WebElement elemento) {
		logger.info(String.format(
				"Realizar a ação do método [esperarElementoSerClicavel] com elemento [%s] por %d segundos", elemento,
				TIMEOUT));
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), TIMEOUT);
		return wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}

	public void esperarElementoAparecer(By elemento) {
		logger.info(
				String.format("Realizar a ação do método [esperarElementoAparecer] com elemento [%s] por %d segundos.",
						elemento, TIMEOUT));
		WebDriver driver = DriverWeb.getDriver();

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(elemento));
	}

	public void esperarPresencaDoElemento(By elemento) {
		logger.info(String.format(
				"Realizar a ação do método [esperarVisibilidadeDoElemento] com elemento [%s] por %d segundos.",
				elemento, TIMEOUT));
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(DriverWeb.getDriver().findElement(elemento)));

	}

	public WebElement esperarPresencaDoElement(By elemento) {

		logger.info(String.format(
				"Realizar a ação do método [esperarVisibilidadeDoElemento] com elemento [%s] por %d segundos.",
				elemento, TIMEOUT));
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), TIMEOUT);
		return wait.until(ExpectedConditions.visibilityOf(DriverWeb.getDriver().findElement(elemento)));
	}

	public WebElement esperarPresencaDoElement(WebElement elemento) {

		logger.info(String.format(
				"Realizar a ação do método [esperarVisibilidadeDoElemento] com elemento [%s] por %d segundos.",
				elemento, TIMEOUT));
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), TIMEOUT);
		return wait.until(ExpectedConditions.visibilityOf(elemento));
	}

}
