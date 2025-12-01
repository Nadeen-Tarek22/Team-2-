package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("demo@demo.com", "demo"); // replace with valid credentials
        Assert.assertTrue(login.isLoggedIn(), "Login failed!");
    }
}