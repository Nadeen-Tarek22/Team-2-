package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SoftwarePage {
    WebDriver driver;



    By softwareTitleLocator = By.xpath("//h2[text()='Software']");
    By emptyMessage = By.xpath("//p[contains(text(),'There are no products')]");
    By continueButton = By.xpath("//a[text()='Continue']");

    WebDriverWait wait;


    public SoftwarePage(WebDriver driver) {

        this.driver = driver;
        wait  = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }

    public String getPageTitle() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated((softwareTitleLocator))).getText();

    }


    public String getEmptyMessage() {

       return wait.until(ExpectedConditions.visibilityOfElementLocated((emptyMessage))).getText();


    }

    public boolean isContinueButtonDisplayed() {

        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(continueButton))).isDisplayed();

    }


}
