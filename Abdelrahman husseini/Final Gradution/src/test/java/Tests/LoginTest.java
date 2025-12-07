package Tests;

import Pages.Account.AccountPage;
import Pages.Account.LoginPage;
import Pages.BaseTest.BaseTestClass;
import org.junit.Test;
import org.testng.Assert;


public class LoginTest extends BaseTestClass {

    @Test
    public void validLogin() {
        loginPage = homePage.clickMyAccount().openLoginPage();
        AccountPage accountPage = new AccountPage(driver);
//        LoginPage loginPage = accountPage.openLoginPage();

        loginPage.login("valid@test.com", "Test12345");

        Assert.assertTrue(loginPage.isLoggedIn(),
                "User should be logged in successfully!");
    }

    @Test
    public void invalidLoginWrongPassword() {
        AccountPage accountPage = new AccountPage(driver);
        LoginPage loginPage = accountPage.openLoginPage();

        loginPage.login("valid@test.com", "Wrong123");

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error should be displayed for wrong password!");
    }

    @Test
    public void invalidLoginWrongEmail() {
        AccountPage accountPage = new AccountPage(driver);
        LoginPage loginPage = accountPage.openLoginPage();

        loginPage.login("notexist@test.com", "Test12345");

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error should be displayed for wrong email!");
    }

    @Test
    public void emptyEmailField() {
        AccountPage accountPage = new AccountPage(driver);
        LoginPage loginPage = accountPage.openLoginPage();

        loginPage.login("", "Test12345");

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error should be displayed for empty email!");
    }

    @Test
    public void emptyPasswordField() {
        AccountPage accountPage = new AccountPage(driver);
        LoginPage loginPage = accountPage.openLoginPage();

        loginPage.login("valid@test.com", "");

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error should be displayed for empty password!");
    }
}
