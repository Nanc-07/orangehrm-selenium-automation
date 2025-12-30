package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.DashboardPage;
import pages.AddEmployeePage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        // Wait a little for page load (simple beginner way)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
    @Test
    public void invalidLoginTest() {

        LoginPage login = new LoginPage(driver);
        login.login("Admin", "wrongpassword");

        String actualError = login.getErrorMessage();
        Assert.assertTrue(actualError.contains("Invalid credentials"));
    }
    @Test
    public void logoutTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.logout();

        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
    @Test
    public void addEmployeeFormTest() {

        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        AddEmployeePage emp = new AddEmployeePage(driver);
        emp.addEmployee("Nancy", "Tester");

        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }



}
