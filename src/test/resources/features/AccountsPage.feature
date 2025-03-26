Feature: Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|su      |gw      |

Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "[DEV mode - 50.12.0.4212] Guidewire PolicyCenter (Super User) My Summary"