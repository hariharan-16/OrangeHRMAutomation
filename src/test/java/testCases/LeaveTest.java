package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LeavePage;
import testComponents.BaseClass;

public class LeaveTest extends BaseClass {

    public DashboardPage dashboardPage;

    @Test
    public void applyLeaveTest(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        LeavePage leavePage = dashboardPage.goToLeavePage();
        leavePage.applyForLeave("2026-07-20", "2026-07-21");

    }

    @Test
    public void searchLeaveTest(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        LeavePage leavePage = dashboardPage.goToLeavePage();
        String result = leavePage.searchLeave("2026-07-20", "2026-07-21");
        System.out.println(result);
        Assert.assertTrue(result.contains("2026-07-20"), "Leave with date 2026-07-20 not found in the list");

    }

}
