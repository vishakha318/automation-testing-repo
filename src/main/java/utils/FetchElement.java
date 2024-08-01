package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class FetchElement {

	public WebElement getElement(String identifierType, String identifierValue) {

		switch (identifierType) {

		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifierValue));

		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(identifierValue));

		case "ID":
			return BaseTest.driver.findElement(By.id(identifierValue));

		case "LINK_TEXT":
			return BaseTest.driver.findElement(By.linkText(identifierValue));

		case "NAME":
			return BaseTest.driver.findElement(By.name(identifierValue));

		case "PARTIAL_LINK_TEXT":
			return BaseTest.driver.findElement(By.partialLinkText(identifierValue));

		case "TAGNAME":
			return BaseTest.driver.findElement(By.tagName(identifierValue));

		default:
			return null;
		}

	}

	public List<WebElement> getElements(String identifierType, String identifierValue) {

		switch (identifierType) {

		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifierValue));

		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(identifierValue));

		case "ID":
			return BaseTest.driver.findElements(By.id(identifierValue));

		case "LINK_TEXT":
			return BaseTest.driver.findElements(By.linkText(identifierValue));

		case "NAME":
			return BaseTest.driver.findElements(By.name(identifierValue));

		case "PARTIAL_LINK_TEXT":
			return BaseTest.driver.findElements(By.partialLinkText(identifierValue));

		case "TAGNAME":
			return BaseTest.driver.findElements(By.tagName(identifierValue));

		default:
			return null;
		}

	}
}
