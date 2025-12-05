package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparePage {

    WebDriver driver;

    public ComparePage(WebDriver driver) {
        this.driver = driver;
    }

    By actualTitleLocator = By.xpath("//h1");
    String expectedTitle = "Product Comparison";

    public String getExpectedTitle(){
        return expectedTitle;
    }

    public String getActualTitle(){
        return driver.findElement(actualTitleLocator).getText();
    }
}
