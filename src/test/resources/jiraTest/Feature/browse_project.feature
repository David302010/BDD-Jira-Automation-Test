@BrowseProject
Feature: browse project
  I want to check if the projects can be found

  Background: open website
    Given User opens the website jira

  Scenario Outline: Browse project
    Given I have logged in to Jira
    When I click on Project AllProjects and do search for a "<searching criteria>"
    Then the searched "<projectName>" should appear with details
    Examples:
      |searching criteria |projectName       |
      |TOUCAN             | TOUCAN projekt   |
      |COALA              | COALA Project    |
      |JETI               | JETI Project     |