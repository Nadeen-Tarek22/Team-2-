package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    By transactionLinkLocator = By.xpath("//a[contains(text(),'Your Transactions')]");

    public TransactionPage clickOnTransactionLink(){
        driver.findElement(transactionLinkLocator).click();
        return new TransactionPage(driver);
    }
}
