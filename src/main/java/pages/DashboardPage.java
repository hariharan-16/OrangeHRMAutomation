package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponents;


import java.util.List;

public class DashboardPage extends AbstractComponents {

    public WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".oxd-topbar-header-breadcrumb h6")
    private WebElement titleText;

    @Getter
    @FindBy(css = ".oxd-userdropdown")
    private WebElement profileButton;

    @FindBy(linkText = "Logout")
    private WebElement logoutOption;

    @FindBy(className = "orangehrm-dashboard-widget-name")
    private List<WebElement> gridElementsName;

    @FindBy(className = "oxd-main-menu")
    private WebElement sideBarMenuLinks;

    @FindBy(linkText = "PIM")
    private WebElement PIMMenuLink;

    @FindBy(linkText = "Admin")
    private WebElement adminMenuLink;

    @FindBy(linkText = "Leave")
    private WebElement leaveMenuLink;

    //Quick Launch Card elements
    @FindBy(xpath = "//button[@title='Assign Leave']")
    private WebElement assignLeaveButton;

    @FindBy(xpath = "//button[@title='Leave List']")
    private WebElement leaveListButton;

    @FindBy(xpath = "//button[@title='Timesheets']")
    private WebElement timeSheetsButton;

    @FindBy(xpath = "//button[@title='Apply Leave']")
    private WebElement applyLeaveButton;

    @FindBy(xpath = "//button[@title='My Leave']")
    private WebElement myLeaveButton;

    @FindBy(xpath = "//button[@title='My Timesheet']")
    private WebElement myTimeSheetButton;

    @FindBy(className = "oxd-userdropdown-link")
    private List<WebElement> profileMenuLinks;

    public Boolean titleTextVisible(String text){
        return titleText.isDisplayed() && titleText.getText().equalsIgnoreCase(text);
    }

    public void logout(){
        profileButton.click();
        logoutOption.click();
    }

    public List<String> gridElementsVisible(){
        return gridElementsName.stream()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .toList();
    }

    public Boolean sideBarMenuLinksVisibility(){
        return sideBarMenuLinks.isDisplayed();
    }

    public Boolean quickLaunchButtonVisibility(){
        return assignLeaveButton.isDisplayed() && leaveListButton.isDisplayed() && timeSheetsButton.isDisplayed() && applyLeaveButton.isDisplayed() && myLeaveButton.isDisplayed() && myTimeSheetButton.isDisplayed();
    }

    public List<String> profileMenuLinksVisible(){
        waitForAllElementVisibility(profileMenuLinks);
        return profileMenuLinks.stream()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .toList();
    }

    public PIMPage goToPIMPage(){
        PIMMenuLink.click();
        return new PIMPage(driver);
    }

    public AdminPage goToAdminPage(){
        adminMenuLink.click();
        return new AdminPage(driver);
    }

    public LeavePage goToLeavePage(){
        leaveMenuLink.click();
        return new LeavePage(driver);
    }

}
