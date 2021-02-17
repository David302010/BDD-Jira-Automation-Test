package jiraTest;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.DashBoardPage;
import util.WebDriverSingleton;

import java.util.concurrent.TimeUnit;


public class StepDefinitions {
    private WebDriver driver = null;
    private LoginPage loginPage = new LoginPage();
    private DashBoardPage dashBoardPage = new DashBoardPage();

    // scenario successful

    @When("I enter userName and password and click Submit")
    public void enterCredentials() {
        loginPage.loginAttempt(System.getenv("userName"), System.getenv("password"));
    }

    @Then("I should see Userprofile with Logout option")
    public void checkForLogout() {
        boolean logout = dashBoardPage.checkLogout();
        assertTrue(logout);

    }

    // scenario incorrect username
    @When("I enter wrong username and password")
    public void enterWrongUsername() {
        loginPage.loginAttempt("invalidName", System.getenv("password"));
    }

    @Then("I should see errormessage due to username")
    public void validateWrongUsernameError(){
        WebElement loginError = loginPage.getLoginError();
        assertNotNull(loginError);
    }

    // scenario incorrect password
    @When("I enter correct username and wrong password")
    public void enterWrongPassword(){
        loginPage.loginAttempt(System.getenv("userName"), "wrongPassword");
    }

    @Then("I should see errormessage due to password")
    public void validateWrongPasswordError(){
        WebElement loginError = loginPage.getLoginError();
        assertNotNull(loginError);
    }

    // scenario logout
    @When("I click on the logout button")
    public void logout() {
        dashBoardPage.logout();
    }

    @Then("Logout page appears with option to log in again")
    public void checkIfLoggedOut() {
        WebElement logoutConfirmation = dashBoardPage.checkLoginAgain();
        assertNotNull(logoutConfirmation);
    }

    // Background
    @Given("User opens the website jira")
    public void userLogsIn() {
        System.out.println("ez itt a background");
        WebDriver driver = WebDriverSingleton.getInstance();
        driver.get("https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa");
        driver.manage().window().maximize();
    }

    // scenario Browse Project
    @Given("I have logged in to Jira")
    public void i_have_logged_in_to_jira() {
        loginPage.loginAttempt(System.getenv("userName"), System.getenv("password"));
        //dashBoardPage.browseProject()
    }


    @When("I click on Project AllProjects and do search for a {string}")
    public void i_click_on_project_all_projects_and_do_search_for_a_project(String project) {
        dashBoardPage.browseProject(project);
    }

    @Then("the searched {string} should appear with details")
    public void the_searched_project_should_appear_with_details(String projectName) {
        String searchedProject = dashBoardPage.findSearchedProject(projectName);
        assertEquals(projectName, searchedProject);
    }

    @After
    public void closeBrowser(){
        WebDriver driver = WebDriverSingleton.getInstance();
        System.out.println("This is the after section");
        driver.close();
    }
}
