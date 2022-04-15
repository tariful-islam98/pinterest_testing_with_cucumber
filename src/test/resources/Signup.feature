Feature: Signup User

  @signup
  Scenario Outline: Check user signup is successful with valid credential
    Given user is in signup page
    When user enters "<Email>" , "<Password>" and "<Age>"
    And clicks continue button
    And clicks next button
    And selects a gender
    And clicks next again
    And selects topics
    And clicks done button
    And clicks done button again
    And clicks save button
    Then home is visible

    Examples:
    | Email | Password | Age |
    | fikkodoltu1@vusra.com | 121212A | 25 |
