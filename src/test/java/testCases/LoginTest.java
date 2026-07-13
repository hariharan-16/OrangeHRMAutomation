package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import testComponents.BaseClass;

public class LoginTest extends BaseClass {

    public DashboardPage dashboardPage;

    @Test(groups = {"smoke", "sanity", "regression"})
    public void loginTest(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(dashboardPage.titleTextVisible("dashboard"), "Not expected text");

    }

    @Test(groups = {"negative", "regression"})
    public void invalidCredentialsTest(){

        landingPage.login(prop.getProperty("username")+System.getProperty("user.timezone"), prop.getProperty("password")+System.getProperty("user.timezone"));
        Assert.assertTrue(landingPage.invalidCredentialsTextVisible(), "Invalid credentials text not displayed");

    }

    @Test(groups = {"negative", "validation"})
    public void emptyCredentialsTest(){

        landingPage.login("", "");
        Assert.assertTrue(landingPage.requiredFieldIsVisible(), "Required field message is not displayed");

    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void logoutTest(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        dashboardPage.logout();
        Assert.assertTrue(landingPage.loginTitleVisible(), "Login title is not displayed");

    }

}
