@Book
Feature: Select Book Form Shop App 
Scenario: Verify Book is added into basket 
	Given user open the browser and open url 
	When user click on shop menu 
	And click on Home menu button 
	Then verify three arrivals are displayed 
	And User select any one image in arrival 
	And User add book into the basket 
	Then user should able to view that added book 
	Then user verify total and subtotal values 
	And click on checkout button 
	And User naviaget to payment gateway page 
	And user select the payment option 
	And user placed the order 
	Then user should navigate to order confirmation page 
	Then close Browser
	
	
	
	
	
	
  