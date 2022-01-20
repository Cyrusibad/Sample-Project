Feature: PhpTravels site
  Scenario Outline: Testing the Hotels tab
    Given User is in the home page of PhpTravels
    When User enters <city> to the SearchByCity textbox
    Examples:
      | city |
      |miami |

  Scenario Outline: testing the login page
    Given User is in the login page of PhpTravels
    When User enters username, password
    And User clicks login button
    And User is in the home page of PhpTravels
    And User enters <city> to the SearchByCity textbox
    And User enters the date for Checkin
    And User enters the date for Checkout
    And User clicks the Search button
    Examples:
    |city|
    |mia|