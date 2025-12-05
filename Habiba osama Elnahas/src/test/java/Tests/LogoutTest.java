package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.HomePage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);

        login.open();
        login.login("demo@demo.com", "demo"); // replace with valid credentials
        Assert.assertTrue(login.isLoggedIn(), "Login failed!");

        home.logout();
        Assert.assertTrue(home.isLoggedOut(), "Logout failed!");
    }
}