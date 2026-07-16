package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponents;

import java.util.List;

public class AdminPage extends AbstractComponents {

    WebDriver driver;
    public AdminPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement addUserButton;

    @FindBy(xpath = "//label[text()='User Role']/parent::div/following-sibling::div")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//div[@role='option']//span[text()='Admin']")
    private WebElement adminUserSelect;

    @FindBy(xpath = "//label[text()='Status']/parent::div/following-sibling::div")
    private WebElement statusDropdown;

    @FindBy(xpath = "//span[text()='Enabled']")
    private WebElement enabledSelect;

    @FindBy(xpath = "//span[text()='Disabled']")
    private WebElement disabledSelect;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameField;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-option']//span")
    private List<WebElement> employeeNameFieldDropdown;

    @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div//input")
    private WebElement employeeUsernameField;

    @FindBy(xpath = "//label[text()='Password']/parent::div/following-sibling::div//input")
    private WebElement employeePasswordField;

    @FindBy(xpath = "//label[text()='Confirm Password']/parent::div/following-sibling::div//input")
    private WebElement employeeConfirmPasswordField;

    @FindBy(className = "oxd-toast--success")
    private WebElement successMessage;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitOrSearchButton;

    @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div//input")
    private WebElement searchUserNameField;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div//div//div[2]")
    private WebElement userNameTableField;

    @FindBy(className = "bi-pencil-fill")
    private WebElement editButton;

    @FindBy(className = "bi-trash")
    private WebElement deleteButton;

    @FindBy(css = ".orangehrm-modal-footer .bi-trash")
    private WebElement modalDeleteButton;


    public void addUser(String employeeName, String username, String password){
        addUserButton.click();
        userRoleDropdown.click();
        adminUserSelect.click();
        statusDropdown.click();
        enabledSelect.click();
        employeeNameField.sendKeys(employeeName);
        employeeNameFieldDropdown.stream().filter(option -> option.getText().equals(employeeName)).findFirst().ifPresent(WebElement::click);
        employeeUsernameField.sendKeys(username);
        employeePasswordField.sendKeys(password);
        employeeConfirmPasswordField.sendKeys(password);
        submitOrSearchButton.click();
        waitForElementVisibility(successMessage);
    }

    public boolean searchUser(String username){
        waitForElementVisibility(searchUserNameField);
        searchUserNameField.sendKeys(username);
        submitOrSearchButton.click();

        waitForElementVisibility(userNameTableField);
        return userNameTableField.getText().equalsIgnoreCase(username);
    }

    public void toggleUserStatus(String username){
        waitForElementVisibility(searchUserNameField);
        searchUserNameField.sendKeys(username);
        submitOrSearchButton.click();

        editButton.click();
        waitForElementVisibility(statusDropdown);
        statusDropdown.click();
        disabledSelect.click();
        submitOrSearchButton.click();
        waitForElementVisibility(successMessage);
    }

    public void deleteUser(String username){
        waitForElementVisibility(searchUserNameField);
        searchUserNameField.sendKeys(username);
        submitOrSearchButton.click();

        waitForElementVisibility(userNameTableField);
        deleteButton.click();
        waitForElementVisibility(modalDeleteButton);
        modalDeleteButton.click();
        waitForElementVisibility(successMessage);
    }

}