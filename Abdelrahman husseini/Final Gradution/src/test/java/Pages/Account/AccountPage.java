package Pages.Account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    WebDriver driver;
    WebDriverWait wait;

    By loginLink = By.xpath("//a[text()='Login']");
    By registerLink = By.xpath("//a[text()='Register']");

    public AccountPage(WebDriver driver) {
        this.driver = driver; // مهم جدًا تمرر driver من Hooks
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public LoginPage openLoginPage() {
//        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
//        return new LoginPage(driver);
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public RegisterPage openRegisterPage() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
        return new RegisterPage(driver);
    }


}
