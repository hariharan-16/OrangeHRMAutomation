package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponents;

import java.util.List;

public class RecruitmentPage extends AbstractComponents {

    public WebDriver driver;

    public RecruitmentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Add Application
    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement addButton;

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(xpath = "//label[text()='Email']/parent::div/following-sibling::div//input")
    private WebElement emailField;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveButton;

    @FindBy(className = "oxd-toast--success")
    private WebElement successMessage;



    // Search Application

    @FindBy(xpath = "//label[text()='Candidate Name']/parent::div/following-sibling::div//input")
    private WebElement candidateName;

    @FindBy(xpath = "//div[@role='option']//span")
    private List<WebElement> candidateNameDropdown;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    @FindBy(className = "oxd-table-loader")
    private WebElement loader;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div//div//div[3]//div")
    private WebElement candidateNameInTable;

    @FindBy(className = "bi-trash")
    private WebElement deleteButton;

    @FindBy(css = ".orangehrm-modal-footer .bi-trash")
    private WebElement modalDeleteButton;

    public void addCandidate(String firstName, String lastName, String email){

        waitForElementVisibility(addButton);
        addButton.click();
        waitForElementVisibility(firstNameField);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        saveButton.click();
        waitForElementVisibility(successMessage);

    }

    public String searchApplication(String name){

        candidateName.sendKeys(name);
        candidateNameDropdown.stream().filter(option -> option.getText().equals("John Doe")).findFirst().ifPresent(WebElement::click);
        searchButton.click();
        waitForElementInvisibility(loader);

        return candidateNameInTable.getText();

    }

    public void deleteApplication(String name){

        candidateName.sendKeys(name);
        candidateNameDropdown.stream().filter(option -> option.getText().equals("John Doe")).findFirst().ifPresent(WebElement::click);
        searchButton.click();
        waitForElementInvisibility(loader);

        deleteButton.click();
        waitForElementVisibility(modalDeleteButton);
        modalDeleteButton.click();

        waitForElementVisibility(successMessage);
    }

}
