package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponents;

public class MyInfoPage extends AbstractComponents {

    public WebDriver driver;

    public MyInfoPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "oxd-table-loader")
    private WebElement loader;

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveButton;

    @FindBy(className = "oxd-toast--success")
    private WebElement successMessage;

    @FindBy(xpath = "//div[@class='orangehrm-edit-employee-image']/img")
    private WebElement profilePicture;

    @FindBy(className = "oxd-file-input")
    private WebElement addImage;

    public void updateDetails(String firstName, String lastName){

        waitForElementInvisibility(loader);
        firstNameField.sendKeys(Keys.CONTROL + "a");
        firstNameField.sendKeys(Keys.DELETE);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(Keys.CONTROL + "a");
        lastNameField.sendKeys(Keys.DELETE);
        lastNameField.sendKeys(lastName);
        saveButton.click();

        waitForElementVisibility(successMessage);

    }

    public void uploadProfilePicture(){

        waitForElementInvisibility(loader);
        profilePicture.click();
        waitForElementInvisibility(loader);
        addImage.sendKeys(System.getProperty("user.dir") + "/src/test/resources/profile.jpg");
        saveButton.click();

        waitForElementVisibility(successMessage);
    }
}
