package com.boltseal.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver driver;
	public static WebDriver launchBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			String key="webdriver.chrome.driver";
			String value="./exefiles/chromedriver.exe";
			System.setProperty(key, value);
			
			driver= new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			String key="webdriver.gecko.driver";
			String value="./exefiles/geckodriver.exe";
			System.setProperty(key, value);
			
			driver= new FirefoxDriver();
			
		}
		return driver;
		
	}

}
