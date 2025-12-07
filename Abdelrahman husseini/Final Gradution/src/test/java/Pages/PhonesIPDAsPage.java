package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PhonesIPDAsPage {

    WebDriver driver;
    WebDriverWait wait;

    By pageTitle = By.xpath("//h2[text()='Phones & PDAs']");
    By productNames = By.xpath("//div[@class='product-thumb']//h4/a");
    By productPrices = By.xpath("//div[@class='product-thumb']//span[contains(@class,'price-new')]");
    By addToCartButtons = By.xpath("//div[@class='product-thumb']//button[@title='Add to Cart']");
    By addToWishListButtons = By.xpath("//div[@class='product-thumb']//button[@title='Add to Wish List']");
    By addToCompareButtons = By.xpath("//div[@class='product-thumb']//button[@title='Compare this Product']");
    By successAlert = By.cssSelector(".alert-success");
    By sortDropdown = By.xpath("//select[@id='input-sort']");
    By showDropdown = By.xpath("//select[@id='input-limit']");

    public PhonesIPDAsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    public int getProductsCount() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productNames)).size();
    }

    public void clickAddToCart(int index) {
        List<WebElement> buttons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(index))).click();
    }

    public boolean isAddToCartSuccess() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert)).isDisplayed();
    }

    public void clickAddToWishList(int index) {
        List<WebElement> buttons =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToWishListButtons));
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(index))).click();
    }

    public void clickAddToCompare(int index) {
        List<WebElement> buttons =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCompareButtons));
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(index))).click();
    }

    public void selectSortBy(String optionText) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(sortDropdown)));
        select.selectByVisibleText(optionText);
    }

    public void selectShowLimit(String optionText) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(showDropdown)));
        select.selectByVisibleText(optionText);
    }

    public String getProductName(int index) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productNames)).get(index).getText();
    }

    public String getProductPrice(int index) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productPrices)).get(index).getText();
    }
}
