Feature: Google Page Feature

  Scenario Outline: Testing the search functionality
    Given user is in the home page of Google
    When user enters <search> term
    Then related results is displayed
    Examples:
    |search|
    |test  |
    |goog  |
    |zxc   |

