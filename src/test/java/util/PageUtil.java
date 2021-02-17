package util;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.DashBoardPage;
import pages.LoginPage;

public class PageUtil {
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;

    public PageUtil(LoginPage loginPage, DashBoardPage dashBoardPage) {
        this.loginPage = loginPage;
        this.dashBoardPage = dashBoardPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public DashBoardPage getDashBoardPage() {
        return dashBoardPage;
    }

    // Background
    public void openPage() {
        System.out.println("ez itt a background");
        WebDriver driver = WebDriverSingleton.getInstance();
        driver.get("https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa");
        driver.manage().window().maximize();
    }

    // After
    public void closeBrowser(){
        WebDriver driver = WebDriverSingleton.getInstance();
        System.out.println("This is the after section");
        driver.close();
    }
}
