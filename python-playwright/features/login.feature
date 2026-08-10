Feature: Sample App Login

  Scenario Outline: Login attempts with various credentials
    Given I am on the sample app page
    When I log in with username "<username>" and password "<password>"
    Then I should see "<message>"

    Examples:
    | username | password  | message                   |
    | UserName | pwd       | Welcome, UserName!        |
    | UserName | wrongpass | Invalid username/password |