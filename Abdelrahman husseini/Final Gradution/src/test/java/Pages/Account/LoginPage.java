package Pages.Account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.xpath("//input[@value='Login']");
    By errorMessage = By.cssSelector(".alert-danger");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(loginButton).click();
        return this;
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public boolean isLoggedIn() {
        return driver.getCurrentUrl().contains("account/account");
    }

    public boolean isErrorDisplayed() {
        return !driver.findElements(errorMessage).isEmpty();
    }

    public String getErrorText() {
        return driver.findElement(errorMessage).getText();
    }



}
