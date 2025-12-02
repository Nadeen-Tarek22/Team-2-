package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;



    By softwareLocator = By.linkText("Software");

    By PhoneIPDAsLocator = By.xpath("//a[contains(text(), 'Phones')]");

    public HomePage(WebDriver driver ,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;


    }


    public SoftwarePage clickSoftware() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement softwareBtn = wait.until(
                ExpectedConditions.elementToBeClickable(softwareLocator)
        );
        softwareBtn.click();
        return new SoftwarePage(driver);
    }




    public PhonesIPDAsPage clickPhonesIPDAs() {



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        WebElement phonesLink = wait.until(ExpectedConditions.elementToBeClickable(PhoneIPDAsLocator));


        phonesLink.click();

        return new PhonesIPDAsPage(driver);
    }
}
