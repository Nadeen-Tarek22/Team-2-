package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PhonesIPDAsPage {

    WebDriver driver;
    WebDriverWait wait;

    // Elements
    By productNames = By.xpath("//div[@class='product-thumb']//h4/a");
    By productPrices = By.xpath("//div[@class='product-thumb']//span[contains(@class,'price-new')]");
    By addToCartButtons = By.xpath("//div[@class='product-thumb']//button[@title='Add to Cart']");
    By addToWishListButtons = By.xpath("//div[@class='product-thumb']//button[@title='Add to Wish List']");
    By addToCompareButtons = By.xpath("//div[@class='product-thumb']//button[@title='Compare this Product']");

    By sortDropdown = By.xpath("//select[@id='input-sort']");
    By showDropdown = By.xpath("//select[@id='input-limit']");

    public PhonesIPDAsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getAllProductNames() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNames));
    }

    public int getProductsCount() {
        List<WebElement> elements =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productNames));
        return elements.size();
    }

    public void clickAddToCart(int index) {
        List<WebElement> buttons =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(index))).click();
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
        WebElement dropdown =
                wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
        dropdown.sendKeys(optionText);
    }

    public void selectShowLimit(String optionText) {
        WebElement dropdown =
                wait.until(ExpectedConditions.elementToBeClickable(showDropdown));
        dropdown.sendKeys(optionText);
    }

    public String getProductName(int index) {
        List<WebElement> names =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productNames));
        return names.get(index).getText();
    }

    public String getProductPrice(int index) {
        List<WebElement> prices =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productPrices));
        return prices.get(index).getText();
    }
}
