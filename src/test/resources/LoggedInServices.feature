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

  #TC_4.6.1
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


  #TC_4.6.2
  Rule: User shares Profile
    Background:
      Given user clicks profile icon
      And clicks share button
      Then Share modal is displayed

    @login
    Scenario Outline: user shares profile
      Given user clicks email input field
      And types the "<email>" address
      And selects contact to share
      And writes "<message>" to share
      And clicks send button
      Then user is returned to share modal

      Examples:
        | email                | message |
        | abir0dhaka@gmail.com | Hello   |

    @login
    Scenario: Share profile using Facebook
      Given user clicks Fb button
      Then Fb window is opened

    @login
    Scenario: Share profile using Twitter
      Given user clicks Twitter button
      Then Twitter window is opened