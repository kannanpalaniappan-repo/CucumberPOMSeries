package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is: " + browser);
		switch(browser.toLowerCase()) {
			case "chrome":tlDriver.set(new ChromeDriver());;break;
			case "edge":tlDriver.set(new EdgeDriver());break;
			default: System.out.println("Please pass the correct browser value: "+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
		
	}
	
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
