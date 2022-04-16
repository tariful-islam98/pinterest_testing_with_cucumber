Feature: Different services

  Background: user is logged in
    Given User is in Login page
    When User Enters Email and Password
    And clicks Login Button
    Then Home Page is Visible

    @login
    Scenario: Notification
      Given user clicks notification icon
      And selects a notification
      Then notification detail page loaded

  @login
  Scenario Outline: User Searches a topic
    Given User clicks search box
    And types a "<topic>"
    And clicks Enter
    Then System shows the result page

    Examples:
      | topic |
      | cricket |