package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.RecruitmentPage;
import testComponents.BaseClass;

public class RecruitmentTest extends BaseClass {

    public DashboardPage dashboardPage;

    @Test(groups = {"functional"})
    public void addCandidateTest(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        RecruitmentPage recruitmentPage = dashboardPage.goToRecruitmentPage();
        recruitmentPage.addCandidate("john", "doe", "johndoe@mail.com");

    }

    @Test(groups = {"functional"})
    public void searchApplicationTest(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        RecruitmentPage recruitmentPage = dashboardPage.goToRecruitmentPage();
        String result = recruitmentPage.searchApplication("John");
        System.out.println(result);
        Assert.assertTrue(result.contains("John Doe"), "Candidate with name John Doe not found in the list");

    }

    @Test(groups = {"functional"})
    public void deleteApplication(){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        RecruitmentPage recruitmentPage = dashboardPage.goToRecruitmentPage();
        recruitmentPage.deleteApplication("John");

    }

}
