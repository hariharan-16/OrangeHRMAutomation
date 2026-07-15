package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.PIMPage;
import testComponents.BaseClass;

public class PIMTest extends BaseClass {
    DashboardPage dashboardPage;
    PIMPage pimPage;
    String sampleFirstName = "John", sampleLastName = "Doe";
    String employeeId;

    @Test(groups = {"smoke", "functional", "regression"})
    public void addEmployeeTest(){
        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        pimPage = dashboardPage.goToPIMPage();
        employeeId = pimPage.addEmployeeAndVerify(sampleFirstName, sampleLastName);
    }

    @Test
    public void searchEmployeeTest(){
        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        pimPage = dashboardPage.goToPIMPage();
        employeeId = pimPage.addEmployeeAndVerify(sampleFirstName, sampleLastName);

        pimPage.getEmployeeListLink().click();
        Assert.assertTrue(pimPage.searchEmployee(employeeId), "Employee with ID " + employeeId + " not found in the list");
    }

    @Test
    public void editEmployeeTest() {
        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        pimPage = dashboardPage.goToPIMPage();
        employeeId = pimPage.addEmployeeAndVerify(sampleFirstName, sampleLastName);

        pimPage.getEmployeeListLink().click();
        pimPage.editEmployee(employeeId);
    }

    @Test
    public void deleteEmployee(){
        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        pimPage = dashboardPage.goToPIMPage();
        employeeId = pimPage.addEmployeeAndVerify(sampleFirstName, sampleLastName);

        pimPage.getEmployeeListLink().click();
        pimPage.deleteEmployee(employeeId);
    }

}
