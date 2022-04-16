Feature: User Signup with Facebook

  @signup
  Scenario: Check user signup with facebook
    Given user is in Signup page
    When User clicks continue with facebook button
    Then Facebook Login window appears