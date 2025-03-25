package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	
	private By username = By.name("Login-LoginScreen-LoginDV-username");
	private By password = By.name("Login-LoginScreen-LoginDV-password");
	private By login = By.cssSelector("div[id=\"Login-LoginScreen-LoginDV-submit_Input\"] div[role=\"button\"]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterUserName(String userName) {
		driver.findElement(username).sendKeys(userName);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(login).click();
	}
}
