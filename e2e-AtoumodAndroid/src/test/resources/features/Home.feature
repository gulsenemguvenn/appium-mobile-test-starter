@smoke
@home
Feature: Home page flow validation

  Scenario: Validate home page flow
    Given I am on the home page
    When I click the Later button
    And I verify the Terms message
    And I accept the Terms
    And If geolocation popup appears I click OK
    And I allow map permission
    And I click the Check later button
    Then I search network "Atoumod"
