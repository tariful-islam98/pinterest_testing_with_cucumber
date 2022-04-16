Feature: Different services

  Background: user is logged in
    Given User is in Login page
    When User Enters Email and Password
    And clicks Login Button
    Then Home Page is Visible

  #TC_4.3
  @login
  Scenario Outline: User Searches a topic
    Given User clicks search box
    And types a "<topic>"
    And clicks Enter
    Then System shows the result page

    Examples:
      | topic   |
      | cricket |

  #TC_4.4
  @login
  Scenario: Notification
    Given user clicks notification icon
    And selects a notification
    Then notification detail page loaded

  #TC_4.5
  @login
  Scenario Outline: user sends message
    Given User clicks message icon
    And user clicks new message button
    When user enters "<email>"
    And selects an email
    And types "<message>"
    And clicks send
    Then message is sent

    Examples:
      | email                | message |
      | abir0dhaka@gmail.com | Hello   |

  #TC_4.6
  @login
  Scenario Outline: user updates profile
    Given User clicks profile icon
    And clicks edit profile button
    When user clicks last name field
    And user sets "<lastname>"
    And clicks profile save button
    Then user profile gets updated

    Examples:
      | lastname |
      | A        |
