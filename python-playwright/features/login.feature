Feature: Sample App Login

  Scenario: Successful login with valid credentials
    Given I am on the sample app page
    When I log in with username "UserName" and password "pwd"
    Then I should see the welcome message