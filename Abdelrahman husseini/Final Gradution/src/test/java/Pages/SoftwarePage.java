package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SoftwarePage {
    WebDriver driver;
    WebDriverWait wait;

    By softwareTitleLocator = By.xpath("//h2[text()='Software']");
    By emptyMessage = By.xpath("//p[contains(text(),'There are no products')]");
    By continueButton = By.xpath("//a[text()='Continue']");

    public SoftwarePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public String getPageTitle() {
        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(softwareTitleLocator)
        );
        return title.getText();
    }

    public String getEmptyMessage() {
        WebElement msg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(emptyMessage)
        );
        return msg.getText();
    }

    public boolean isContinueButtonDisplayed() {
        WebElement btn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(continueButton)
        );
        return btn.isDisplayed();
    }


}
