Feature: login in gurru website 
Scenario: login with correct username and password 
	Given I am on login page 
	And I enter username and password 
	When I click on sumbit button 
	Then he should homepage should be displayed 