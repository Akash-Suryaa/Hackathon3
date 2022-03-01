@bookHotel
Feature: Verify login functionality
Scenario: Login Test
        Given user navigate to Search Hotel page
        When fill mandetory information 
        Then click on search option
        And Select Hotel
        And Book Hotel
        And Verify Order ID
        Then close Browser
        
        