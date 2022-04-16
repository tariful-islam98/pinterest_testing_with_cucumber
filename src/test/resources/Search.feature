Feature: Search

  @login
  Scenario Outline: User Searches a topic
    Given User is logged in with "<email>" and "<password>"
    And User is in Home Page
    When User clicks search box
    And types a "<topic>"
    And clicks Enter
    Then System shows the result page

    Examples:
      | email | password | topic |
      | vespimerka6@vusra.com | 121212A | cricket |