package testComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Properties prop;
    public LandingPage landingPage;

    public WebDriver initializeBrowser(){
        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

        if(browserName.contains("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            if (browserName.contains("Headless")){
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.contains("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--incognito");
            if (browserName.contains("firefoxHeadless")){
                options.addArguments("headless");
            }
            driver = new FirefoxDriver(options);
        } else if (browserName.contains("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--incognito");
            if (browserName.contains("edgeHeadless")){
                options.addArguments("headless");
            }
            driver = new EdgeDriver(options);
        }

        if (!browserName.equalsIgnoreCase("chromeHeadless")
                && !browserName.equalsIgnoreCase("firefoxHeadless") && !browserName.equalsIgnoreCase("edgeHeadless")) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/GlobalData.properties"));

        driver = initializeBrowser();
        landingPage = new LandingPage(driver);
        landingPage.goTo(prop.getProperty("url"));

        return landingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void closeApplication(){
        if (driver != null){
            driver.quit();
        }
    }


}
