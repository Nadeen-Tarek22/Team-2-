
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ComponentsPage {

    WebDriver driver;

    public ComponentsPage(WebDriver driver) {
        this.driver = driver;
    }


    By addToCartLocator = By.cssSelector("button[aria-label='Add to Cart']");
    By actualTitleLocator = By.xpath("//h1[contains(text(),'Components')]");
    By emptyCategoryLocator = By.linkText("Monitors");
    By emptyMessageLocator = By.xpath("//*[contains(text(),'There are no products to list')]");

    By productNameLocator = By.cssSelector(".product-thumb h4");
    By productPriceLocator = By.cssSelector(".price");
    By productImageLocator = By.cssSelector(".product-thumb img");


    public String getActualTitle() {
        return driver.findElement(actualTitleLocator).getText();
    }

    public void openEmptyComponentCategory() {
        driver.findElement(emptyCategoryLocator).click();
    }

    public boolean isEmptyCategoryMessageDisplayed() {
        return driver.findElement(emptyMessageLocator).isDisplayed();
    }

    public boolean allProductsHaveName() {
        List<WebElement> names = driver.findElements(productNameLocator);
        if (names == null || names.isEmpty()) {
            return false;
        }
        for (WebElement el : names) {
            String text = el.getText();
            if (text == null || text.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean allProductsHavePrice() {
        List<WebElement> prices = driver.findElements(productPriceLocator);
        if (prices == null || prices.isEmpty()) {
            return false;
        }
        for (WebElement el : prices) {
            String text = el.getText();
            if (text == null || text.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean allProductsHaveImage() {
        List<WebElement> images = driver.findElements(productImageLocator);
        if (images == null || images.isEmpty()) {
            return false;
        }
        for (WebElement el : images) {
            String src = el.getAttribute("src");
            if (src == null || src.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void addAllItemsToCart() {
        List<WebElement> addToCartButtons = driver.findElements(addToCartLocator);
        for (WebElement button : addToCartButtons) {
            button.click();
        }
    }


    public void clickAllAddToCartButtons() {
        addAllItemsToCart();
    }
}
