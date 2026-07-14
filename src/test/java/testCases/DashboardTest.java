package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import testComponents.BaseClass;

import java.util.List;

public class DashboardTest extends BaseClass {

    public DashboardPage dashboardPage;

    @Test(groups = {"smoke", "sanity"})
    public void dashboardPageNavigationTest(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(dashboardPage.titleTextVisible("dashboard"), "Not expected text");

    }

    @Test(groups = {"functional", "regression"})
    public void gridElementsVisibilityTest(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        List<String> widgets = dashboardPage.gridElementsVisible();
        Assert.assertFalse(widgets.isEmpty(), "No widgets are visible on the dashboard");

    }

    @Test(groups = {"functional", "regression"})
    public void sideBarLinksVisibilityTest(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(dashboardPage.sideBarMenuLinksVisibility(), "Sidebar menu links are not visible");

    }

    @Test(groups = {"functional"})
    public void quickLaunchCardButtonVisibilityTest(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(dashboardPage.quickLaunchButtonVisibility(), "Quick launch buttons are not visible");

    }

    @Test(groups = "functional")
    public void profileMenuVisibility(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        dashboardPage.getProfileButton().click();
        List<String> menuItems = dashboardPage.profileMenuLinksVisible();
        Assert.assertFalse(menuItems.isEmpty(), "Profile menu items are not visible");

    }

}
