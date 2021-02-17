package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebDriverSingleton;

import java.util.concurrent.TimeUnit;

public class DashBoardPage {
    WebDriver driver = WebDriverSingleton.getInstance();
    WebDriverWait wait = new WebDriverWait(driver, 5);

    public DashBoardPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 4), this);
    }

    @FindBy(xpath="//img[starts-with(@alt, 'User profile')]")
    private WebElement userIcon;

    @FindBy(id="log_out")
    private WebElement logout;

    @FindBy(id="view_profile")
    private WebElement userProfile;

    @FindBy(xpath = "//h1[contains(text(),'Logout')]")
    private WebElement logoutConfirmation;

    @FindBy(id = "browse_link")
    private WebElement browseLink;

    @FindBy(id = "project_view_all_link")
    private WebElement viewAllLink;

    @FindBy(id = "project-filter-text")
    private WebElement projectFilterText;

    @FindBy(id = "create_link")
    private WebElement createIssue;

    @FindBy(id="find_link")
    private WebElement issuesButton;

    @FindBy(id="filter_lnk_reported_lnk")
    private WebElement reportedByMe;

    @FindBy(id="searcher-query")
    private WebElement searchQuery;

    @FindBy(xpath = "//div[@id=\"aui-flag-container\"]//span[contains(@class,'icon-close')]")
    private WebElement popUpClose;

    public boolean checkLogout() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(userIcon));
        userIcon.click();
        return logout.isDisplayed();
    }

    public void logout(){
        try {
//            wait.until(ExpectedConditions.visibilityOf(userIcon));
            wait.until(ExpectedConditions.elementToBeClickable(userIcon));
            userIcon.click();
            logout.click();
        } catch (Exception ee) {
            System.out.println("not logged in?");
        }

        try {
            wait.until(ExpectedConditions.visibilityOf(logoutConfirmation));
        }catch (TimeoutException e){
            System.out.println("no logout confirmation?");
        }
    }

    public void browseProject(String projectName){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        browseLink.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        viewAllLink.click();
        projectFilterText.sendKeys(projectName);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        String xpathTerm = String.format("//a[starts-with(@title,'%s')]", projectName);
        driver.findElement(By.xpath(xpathTerm)).click();
    }

    public String findSearchedProject(String projectName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String checkIconXpath = String.format("//img[starts-with(@alt, '%s')]", projectName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkIconXpath)));
        WebElement icon = driver.findElement(By.xpath(checkIconXpath));
        return icon.getAttribute("alt");
    }

    public WebElement checkLoginAgain() {
        try {
            wait.until(ExpectedConditions.visibilityOf(logoutConfirmation));
        }catch (TimeoutException e){
            System.out.println("no logout confirmation?");
        }
        return logoutConfirmation;
    }
}
