package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h5")
    private WebElement pageHeading;

    @FindBy(name = "username")
    private WebElement userNameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".oxd-alert-content p")
    private WebElement invalidCredentialsText;

    @FindBy(xpath = "//input[@name='username']/parent::div/parent::div//span")
    private WebElement usernameRequiredField;

    @FindBy(xpath = "//input[@name='password']/parent::div/parent::div//span")
    private WebElement passwordRequiredField;

    public void goTo(String url){
        driver.get(url);
    }

    public DashboardPage login(String username, String password){
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();

        return new DashboardPage(driver);
    }

    public Boolean invalidCredentialsTextVisible(){
        return invalidCredentialsText.isDisplayed();
    }

    public Boolean requiredFieldIsVisible(){
        return userNameField.isDisplayed() || passwordField.isDisplayed();
    }

    public Boolean loginTitleVisible(){
        return pageHeading.isDisplayed();
    }
}
