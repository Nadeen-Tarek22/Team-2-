package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.Account.AccountPage;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By softwareLocator = By.linkText("Software");
    By phonesLinkLocator = By.linkText("Phones & PDAs");
    By accountLocator = By.xpath("//span[text()='My Account']");

    public HomePage(WebDriver driver ,WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public SoftwarePage clickSoftwarePage() {
        WebElement softwareBtn = wait.until(
                ExpectedConditions.elementToBeClickable(softwareLocator)
        );
        softwareBtn.click();
        return new SoftwarePage(driver);
    }

    public PhonesIPDAsPage clickPhonesIPDAs() {
        WebElement phonesBtn = wait.until(
                ExpectedConditions.elementToBeClickable(phonesLinkLocator)
        );
        phonesBtn.click();
        return new PhonesIPDAsPage(driver);
    }

    public AccountPage clickMyAccount() {
        WebElement accountLink = wait.until(
                ExpectedConditions.elementToBeClickable(accountLocator)
        );
        accountLink.click();
        return new AccountPage(driver);
    }
}
