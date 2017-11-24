package com.missionsky.autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaiduSearchAutoTest {

	private WebDriver webDriver;

	private void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "..\\Drivers\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get("https://www.baidu.com");
	}

	@Test(priority = 1)
	public void search() {
		openBrowser();

		WebElement keywordElement = findElementById("kw");
		keywordElement.sendKeys("Selenium WebDriver");

		WebElement submitElement = findElementById("su");
		submitElement.click();

		close();
	}

	private WebElement findElementById(String id) {
		By by = By.id(id);
		return webDriver.findElement(by);
	}

	private void close() {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		webDriver.close();
	}

}
