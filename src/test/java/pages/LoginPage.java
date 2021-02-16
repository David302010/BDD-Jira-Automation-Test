package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebDriverSingleton;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    
    WebDriver driver = WebDriverSingleton.getInstance();
    WebDriverWait wait = new WebDriverWait(driver, 5);

    @FindBy(id = "login-form-username")
    private WebElement username;

    @FindBy(id = "login-form-password")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//div/p[contains(text(),'Sorry, your username and password are incorrect - please try again.')]")
    private WebElement loginError;

    
    public void loginAttempt(String userName, String passWord) {
        driver.manage().window().maximize();
        try {
            wait.until(ExpectedConditions.visibilityOf(username));
            username.sendKeys(userName);
            password.sendKeys(passWord);
            loginButton.click();
        } catch (Exception e ) {
            System.out.println("I'm in already");
        }
    }

    public WebElement getLoginError() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return loginError;
    }
}
