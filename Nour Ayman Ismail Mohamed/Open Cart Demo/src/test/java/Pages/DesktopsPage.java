package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DesktopsPage {

    WebDriver driver;

    public DesktopsPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }
    By addToCartLocator = By.cssSelector("button[aria-label='Add to Cart']");
    String expectedTitle = "Desktops";
    By actualTitleLocator = By.xpath("//h1[contains(text(),'Desktops')]");
    By nextPageButtonLocator = By.linkText("2");
    By compareButtonLocator= By.xpath("//span[text()='Product Compare (0)']");
    By cartAmountLocator = By.xpath("//button[contains(text(),'item(s)')]");
    public void addAllItemsToCart(){
        List<WebElement> addToCart = driver.findElements(addToCartLocator);

        for(WebElement button : addToCart) {
            button.click();
        }
    }

    public String getExpectedTitle(){
        return expectedTitle;
    }
    public String getActualTitle(){
        return driver.findElement(actualTitleLocator).getText();
    }
    public DesktopsPage clickOnNextPage() {
        String oldUrl = driver.getCurrentUrl();
        driver.findElement(nextPageButtonLocator).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));

        return new DesktopsPage(driver);
    }
    public ComparePage clickOnCompareButton(){
        driver.findElement(compareButtonLocator).click();
        return new ComparePage(driver);
    }
    public List<WebElement> getAllAddToCartButtons() {
        return driver.findElements(addToCartLocator);
    }

    public int getCartItemCount() {
        String amount = driver.findElement(cartAmountLocator).getText();
        return Integer.parseInt(amount.split(" ")[0]);
    }
}

