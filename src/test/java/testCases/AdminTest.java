package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.DashboardPage;
import testComponents.BaseClass;

import java.util.HashMap;

public class AdminTest extends BaseClass {
    public DashboardPage dashboardPage;

    @Test(groups = {"smoke", "functional", "regression"}, dataProvider = "getData")
    public void addUserTest(HashMap<Object, Object> data) throws InterruptedException {

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        AdminPage adminPage = dashboardPage.goToAdminPage();
        adminPage.addUser(data.get("employeeName").toString(), data.get("username").toString(), data.get("password").toString());
    }

    @Test(groups = "functional", dataProvider = "getData")
    public void searchUserTest(HashMap<Object, Object> data){

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        AdminPage adminPage = dashboardPage.goToAdminPage();
        Assert.assertTrue(adminPage.searchUser(data.get("username").toString()), "User with username " + data.get("username").toString() + " not found in the list");
    }

    @Test(groups = "functional", dataProvider = "getData")
    public void editUserTest(HashMap<Object, Object> data) throws InterruptedException {

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        AdminPage adminPage = dashboardPage.goToAdminPage();
        adminPage.toggleUserStatus(data.get("username").toString());

        Thread.sleep(10000);
    }

    @Test(groups = "functional", dataProvider = "getData")
    public void deleteUserTest(HashMap<Object, Object> data) throws InterruptedException {

        dashboardPage = landingPage.login(prop.getProperty("username"), prop.getProperty("password"));
        AdminPage adminPage = dashboardPage.goToAdminPage();
        adminPage.deleteUser(data.get("username").toString());

        Thread.sleep(5000);
    }

    @DataProvider
    public Object[][] getData(){
        HashMap<Object, Object> map1 = new HashMap<Object, Object>();
        map1.put("employeeName", "John Doe");
        map1.put("username", "johndoe");
        map1.put("password", "Password123!");

        return new Object[][]{{map1}};
    }

}
