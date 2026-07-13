package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".oxd-topbar-header-breadcrumb h6")
    private WebElement titleText;

    @FindBy(css = ".oxd-userdropdown")
    private WebElement profileButton;

    @FindBy(linkText = "Logout")
    private WebElement logoutOption;

    public Boolean titleTextVisible(String text){
        return titleText.isDisplayed() && titleText.getText().equalsIgnoreCase(text);
    }

    public void logout(){
        profileButton.click();
        logoutOption.click();
    }

}
