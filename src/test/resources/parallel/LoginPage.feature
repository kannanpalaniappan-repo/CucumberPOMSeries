Feature: Login Page Feature

Scenario: Login Page Title
	Given user is on login page
	When user gets the title of the page
	Then page title should be "[DEV mode - 50.12.0.4212] Guidewire PolicyCenter"
	
Scenario: Login With Correct Credentials
	Given user is on login page
	When user enters username "su"
	And user enters password "gw"
	And user clicks on login button
	Then user gets the title of the page
	And page title should be "[DEV mode - 50.12.0.4212] Guidewire PolicyCenter (Super User) My Summary"