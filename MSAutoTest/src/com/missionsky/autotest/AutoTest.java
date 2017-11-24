package com.missionsky.autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoTest {

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "..\\Drivers\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.baidu.com");

		WebElement keywordElement = findElementById(chromeDriver, "kw");
		keywordElement.sendKeys("Web Driver");

		WebElement submitElement = findElementById(chromeDriver, "su");
		submitElement.click();

		close(chromeDriver);
	}

	private WebElement findElementById(WebDriver webDriver, String id) {
		By by = By.id(id);
		return webDriver.findElement(by);
	}

	private void close(WebDriver chromeDriver) {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		chromeDriver.close();
	}

}
