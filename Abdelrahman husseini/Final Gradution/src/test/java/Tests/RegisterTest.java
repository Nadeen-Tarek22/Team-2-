package Tests;

import Pages.Account.AccountPage;
import Pages.Account.RegisterPage;
import Pages.BaseTest.BaseTestClass;
import Pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.Assert;



public class RegisterTest extends BaseTestClass {

    By errorMessages = By.cssSelector(".text-danger, .alert-danger");

    public boolean isErrorDisplayed() {
        return !driver.findElements(errorMessages).isEmpty();
    }

    @Test
    public void validRegistration() {

        AccountPage accountPage = new AccountPage(driver);
        RegisterPage registerPage = accountPage.openRegisterPage();

        String uniqueEmail = "valid" + System.currentTimeMillis() + "@test.com";

        registerPage.registerUser("Abdelrahman", "Ahmed",
                uniqueEmail, "01000000001", "Test12345");

        Assert.assertTrue(registerPage.isAccountCreated(),
                "Account should be created successfully in valid case!");
    }

    @Test
    public void missingLastName() {
        AccountPage accountPage = new AccountPage(driver);
        RegisterPage registerPage = accountPage.openRegisterPage();

        registerPage.registerUser("Abdelrahman", "",
                "nolast" + System.currentTimeMillis() + "@test.com",
                "01000000002", "Test12345");

        Assert.assertTrue(isErrorDisplayed(), "Error must appear!");
    }

    @Test
    public void invalidEmailFormat() {
        AccountPage accountPage = new AccountPage(driver);
        RegisterPage registerPage = accountPage.openRegisterPage();

        registerPage.registerUser("Mohamed", "Ali",
                "invalid-email", "01000000003", "Test12345");

        Assert.assertTrue(isErrorDisplayed(), "Error must appear!");
    }

    @Test
    public void shortPassword() {
        AccountPage accountPage = new AccountPage(driver);
        RegisterPage registerPage = accountPage.openRegisterPage();

        registerPage.registerUser("Yousef", "Mostafa",
                "shortpass" + System.currentTimeMillis() + "@test.com",
                "01000000004", "123");

        Assert.assertTrue(isErrorDisplayed(), "Error must appear!");
    }

    @Test
    public void missingFirstName() {
        AccountPage accountPage = new AccountPage(driver);
        RegisterPage registerPage = accountPage.openRegisterPage();

        registerPage.registerUser("",
                "Salah",
                "nofirst" + System.currentTimeMillis() + "@test.com",
                "01000000005",
                "Test12345"
        );

        Assert.assertTrue(isErrorDisplayed(), "Error must appear!");
    }
}
