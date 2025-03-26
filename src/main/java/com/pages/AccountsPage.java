package com.pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;

public class AccountsPage {

	private WebDriver driver;
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
}
