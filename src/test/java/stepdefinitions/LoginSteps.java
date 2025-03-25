package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;

	@Given("user is on login page")
	public void user_is_on_login_page() {
	  DriverFactory.getDriver().get("https://pc-dev-gwcpdev.cpaspire.zeta1-andromeda.guidewire.net/PolicyCenter.do");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("page title is : " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	   Assert.assertTrue(title.contains(expectedTitle));
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	   loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    loginPage.clickOnLogin();
		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
	}
	
}
