package jiraTest;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    //private WebDriver driver = null;

    public WebDriver login(WebDriver driver, String userName, String password){
        System.out.println("itt kellene belogolni");
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.get("https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa");
        driver.manage().window().maximize();
        driver.findElement(By.id("login-form-username")).sendKeys(userName);
        driver.findElement(By.id("login-form-password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        return driver;
    }
}
