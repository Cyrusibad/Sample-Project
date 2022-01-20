Feature: automation practice web application
  Scenario Outline: testing the login functionality
    Given User is in the login page of AutomationPractice site
    When User enters <username> and <password>
    And clicks the login button
    Then user is logged in
    Examples:
      | username | password |
      |test.123106@yahoo.com|test12345|

  Scenario: Testing functionalities of T-Shirts Tab
    Given user is in the home page of AutomationPractice site
    When user clicks on T-Shirts tab
    And sets the slider for price range
    And clicks the AddToCart Button
    And clicks the proceed to checkout button
    Then user will be redirected to Orders page

  Scenario Outline: End-to-end from Login to Orders
    Given User is in the login page of AutomationPractice site
    And User enters <username> and <password>
    And clicks the login button
    And user is logged in
    And user is in the home page of AutomationPractice site
    And user clicks on T-Shirts tab
    And sets the slider for price range
    And clicks the AddToCart Button
    And clicks the proceed to checkout button
    And user will be redirected to Orders page
    When user clicks on proceed to checkout button on order summary page
    And user is in the Address Tab
    And clicks on proceed to checkout button on Address Page
    And ticks the Terms of Service checkbox
    And clicks the proceed to checkout button on Shipping page
    And selects Pay by check as payment option
    And clicks the I confirm my order button
    Then order will be complete
    Examples:
      | username | password |
      |test.123106@yahoo.com|test12345|

  Scenario: Testing functionalities of Dresses tab
    Given user is in the home page of AutomationPractice site
    When user selects Casual Dresses
    Then user is redirected to Casual Dresses subcategory

  Scenario Outline: Verify total Price
    Given User is in the login page of AutomationPractice site
    And User enters <username> and <password>
    And clicks the login button
    And user is logged in
    And user is in the home page of AutomationPractice site
    And user clicks on T-Shirts tab
    And clicks the AddToCart Button
    And user selects Casual Dresses
    And user is redirected to Casual Dresses subcategory
    And clicks the AddToCart Button
    And user is in the home page of AutomationPractice site
    And user selects Summer Dresses
    And user is redirected to Summer Dresses subcategory
    And clicks the AddToCart Button
    And clicks the proceed to checkout button
    When user verifies the total price
    Examples:
      | username | password |
      |test.123106@yahoo.com|test12345|

  Scenario Outline: Testing search functionality
    Given user is in the home page of AutomationPractice site
    When user enters <search> on search bar
    Then results is displayed
    Examples:
      | search |
      |casual  |
