package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponents;

public class LeavePage extends AbstractComponents {

    WebDriver driver;
    public LeavePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Apply")
    private WebElement applyLeaveMenuLink;

    @FindBy(xpath = "//label[text()='Leave Type']/parent::div/following-sibling::div")
    private WebElement leaveTypeDropdown;

    @FindBy(xpath = "//span[text()='CAN - Vacation']")
    private WebElement leaveTypeChoice;

    @FindBy(xpath = "//label[text()='From Date']/parent::div/following-sibling::div//input")
    private WebElement fromDate;

    @FindBy(xpath = "//label[text()='To Date']/parent::div/following-sibling::div//input")
    private  WebElement toDate;

    @FindBy(xpath = "//button[text()=' Apply ']")
    private WebElement applyButton;

    @FindBy(className = "oxd-toast--success")
    private WebElement successMessage;

    @FindBy(linkText = "My Leave")
    private WebElement myLeaveButton;

    @FindBy(xpath = "//label[text()='Show Leave with Status']/parent::div/following-sibling::div")
    private WebElement leaveStatusDropdown;

    @FindBy(xpath = "//span[text()='Cancelled']")
    private WebElement cancelledChoice;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div//div//div[2]")
    private WebElement resultDateColumn;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    public void applyForLeave(String leaveFromDate, String leaveToDate){
        applyLeaveMenuLink.click();
        waitForElementVisibility(leaveTypeDropdown);
        leaveTypeDropdown.click();
        leaveTypeChoice.click();
        fromDate.sendKeys(leaveFromDate);
        toDate.sendKeys(Keys.CONTROL + "a");
        toDate.sendKeys(Keys.DELETE);
        toDate.sendKeys(leaveToDate);
        applyButton.click();
        waitForElementVisibility(successMessage);
    }

    public String searchLeave(String leaveFromDate, String leaveToDate){
        myLeaveButton.click();
        waitForElementVisibility(fromDate);
        fromDate.sendKeys(leaveFromDate);
        toDate.sendKeys(Keys.CONTROL + "a");
        toDate.sendKeys(Keys.DELETE);
        toDate.sendKeys(leaveToDate);
//        leaveStatusDropdown.click();
//        cancelledChoice.click();
        searchButton.click();
        waitForElementVisibility(resultDateColumn);

        return resultDateColumn.getText();
    }
}
