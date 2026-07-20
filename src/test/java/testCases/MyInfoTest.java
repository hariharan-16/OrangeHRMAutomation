package testCases;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.MyInfoPage;
import testComponents.BaseClass;

public class MyInfoTest extends BaseClass {

    public DashboardPage dashboardPage;

    @Test(groups = {"functional"})
    public void updateDetails(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        MyInfoPage myInfoPage = dashboardPage.goToMyInfoPage();
        myInfoPage.updateDetails("John", "Doe");

    }

    @Test(groups = {"functional"})
    public void uploadProfilePicture(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        MyInfoPage myInfoPage = dashboardPage.goToMyInfoPage();
        myInfoPage.uploadProfilePicture();

    }

}
