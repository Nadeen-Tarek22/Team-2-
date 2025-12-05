package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionPage {
    WebDriver driver;

    public TransactionPage(WebDriver driver) {
        this.driver = driver;
    }
    By actualTitleLocator = By.xpath("//h1[contains(text(),'Your Transactions')]");
    String expectedTitle = "Your Transactions";
    By tableLocator = By.xpath("//table[@class='table table-bordered table-hover']");

    public String getExpectedTitle(){
        return expectedTitle;
    }
    public String getActualTitle(){
        return driver.findElement(actualTitleLocator).getText();
    }
    public boolean isTableDisplayed() {
        return driver.findElement(tableLocator).isDisplayed();
    }
}
