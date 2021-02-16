@Login
Feature: jira-login
  I want to log in to Jira

  Background: open website
    Given User opens the website jira

#  Scenario: I have the credentials to log in to Jira
#    When I enter userName and password and click Submit
#    Then I should see Userprofile with Logout option
#
#  Scenario: I use incorrect username
#    When I enter wrong username and password
#    Then I should see errormessage due to username
#
#  Scenario: I use incorrect password
#    When I enter correct username and wrong password
#    Then I should see errormessage due to password


#Feature: browse project
#  I want to check if the projects can be found

  Scenario Outline: Browse project
    Given I have logged in to Jira
    When I click on Project AllProjects and do search for a "<searching criteria>"
    Then the searched "<projectName>" should appear with details
    Examples:
      |searching criteria |projectName       |
      |TOUCAN             | TOUCAN projekt   |
      |COALA              | COALA Project    |
      |JETI               | JETI Project     |





