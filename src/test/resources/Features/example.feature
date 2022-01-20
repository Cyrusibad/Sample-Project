Feature: Login Functionality

  Scenario Outline: Testing the Login functionality
    Given user is in the login page
    When user enters correct <username> and <password>
    Then user will be logged in
    Examples:
    |username|password|
    |opensourcecms|opensourcecms|