package core.web;

import org.openqa.selenium.By;

public class WebBaseElements {

	public By id(String elementSelector) {
		return By.id(elementSelector);
	}

	public By xpath(String elementSelector) {
		return By.xpath(elementSelector);
	}

	public By tag(String elementSelector) {
		return By.tagName(elementSelector);
	}

	public By css(String elementSelector) {
		return By.cssSelector(elementSelector);
	}

	public By link(String elementSelector) {
		return By.linkText(elementSelector);
	}

	public By partialLink(String elementSelector) {
		return By.partialLinkText(elementSelector);
	}

	public By className(String elementSelector) {
		return By.className(elementSelector);
	}

	public By name(String elementSelector) {
		return By.name(elementSelector);
	}

}
