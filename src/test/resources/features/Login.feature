Feature: Login feature
  Scenario: Login Success
    Given I open browser
    And I open Login Page
    When I enter email "iq14111991@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

