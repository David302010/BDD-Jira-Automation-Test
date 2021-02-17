@Logout
Feature: Jira -Logout
  User wants to log out from Jira

  Background: open website
    Given User opens the website jira
    Given I enter userName and password and click Submit

  Scenario: I log out from Jira
    When I click on the logout button
    Then Logout page appears with option to log in again
