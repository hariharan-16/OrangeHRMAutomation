package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.AbstractComponents;

public class PIMPage extends AbstractComponents {

    WebDriver driver;
    public PIMPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Getter
    @FindBy(linkText = "Employee List")
    private WebElement employeeListLink;

    @Getter
    @FindBy(linkText = "Add Employee")
    private WebElement addEmployeeLink;

    @Getter
    @FindBy(linkText = "Reports")
    private WebElement reportsLink;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div//div//div[2]")
    private WebElement tableIdField;

    @FindBy(className = "oxd-form-loader")
    private WebElement loader;

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "middleName")
    private WebElement middleNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveOrSearchButton;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/parent::div//input")
    private WebElement employeeIdTextField;

    @FindBy(className = "bi-pencil-fill")
    private WebElement editButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-form-hint']/parent::div//button")
    private WebElement personalDetailsSaveButton;

    @FindBy(className = "bi-trash")
    private WebElement deleteButton;

    @FindBy(css = ".orangehrm-modal-footer .bi-trash")
    private WebElement modalDeleteButton;

    public String addEmployeeAndVerify(String firstname, String lastname){
        addEmployeeLink.click();

        waitForElementInvisibility(loader);
        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastname);
        saveOrSearchButton.click();

        waitForElementInvisibility(loader);
        return employeeIdTextField.getAttribute("value");
    }

    public Boolean searchEmployee(String employeeId){
        waitForElementVisibility(employeeIdTextField);
        employeeIdTextField.sendKeys(employeeId);
        saveOrSearchButton.click();
        return tableIdField.getText().equals(employeeId);
    }

    public void editEmployee(String employeeId){
        searchEmployee(employeeId);
        editButton.click();
        middleNameField.sendKeys("test");
        personalDetailsSaveButton.click();
    }

    public void deleteEmployee(String employeeId){
        searchEmployee(employeeId);

        waitForElementVisibility(deleteButton);
        deleteButton.click();

        waitForElementVisibility(modalDeleteButton);
        modalDeleteButton.click();
    }

}
