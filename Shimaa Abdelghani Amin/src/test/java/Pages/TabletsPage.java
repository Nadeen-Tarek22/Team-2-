package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TabletsPage {

    WebDriver driver;

    public TabletsPage(WebDriver driver) {
        this.driver = driver;
    }

   
    By pageTitleLocator = By.xpath("//h2[contains(text(),'Tablets')]");
    By firstTabletNameLocator = By.xpath("(//div[@class='caption']//a)[1]");
    By firstTabletPriceLocator = By.xpath("(//p[@class='price'])[1]");
    By allProductsLocator = By.cssSelector(".product-layout");
    By addToCartButtons = By.cssSelector("button[onclick*='cart.add']");
    By quantityInput = By.cssSelector("input[name*='quantity']");
    By cartCountLocator = By.id("cart-total");

    By sortDropdown = By.id("input-sort");
    By showDropdown = By.id("input-limit");


    public String getPageTitle() {
        return driver.findElement(pageTitleLocator).getText();
    }


    public String getActualTitle() {
        return getPageTitle();
    }

    public String getExpectedTitle() {
        return "Tablets";
    }

    public String getFirstTabletName() {
        return driver.findElement(firstTabletNameLocator).getText();
    }

    public String getFirstTabletPrice() {
        return driver.findElement(firstTabletPriceLocator).getText();
    }

    public void selectSortOption(String visibleText) {
        org.openqa.selenium.support.ui.Select select =
                new org.openqa.selenium.support.ui.Select(driver.findElement(sortDropdown));
        select.selectByVisibleText(visibleText);
    }

    public void selectShowOption(String visibleText) {
        org.openqa.selenium.support.ui.Select select =
                new org.openqa.selenium.support.ui.Select(driver.findElement(showDropdown));
        select.selectByVisibleText(visibleText);
    }


    public boolean allProductsHaveImage() {
        List<WebElement> products = driver.findElements(allProductsLocator);
        for (WebElement product : products) {
            if (product.findElements(By.tagName("img")).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean allProductsHaveName() {
        List<WebElement> products = driver.findElements(allProductsLocator);
        for (WebElement product : products) {
            if (product.findElements(By.cssSelector(".caption a")).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean allProductsHavePrice() {
        List<WebElement> products = driver.findElements(allProductsLocator);
        for (WebElement product : products) {
            if (product.findElements(By.cssSelector(".price")).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void addAllItemsToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (WebElement button : buttons) {
            button.click();
        }
    }

    public List<WebElement> getAllAddToCartButtons() {
        return driver.findElements(addToCartButtons);
    }

    public int getCartItemCount() {
        String cartText = driver.findElement(cartCountLocator).getText();
        // Assuming format: "x item(s) - $y"
        return Integer.parseInt(cartText.split(" ")[0]);
    }

    public String getCurrentProductCount() {
        return driver.findElement(quantityInput).getAttribute("value");
    }

    public void changeProductCount() {
        WebElement input = driver.findElement(quantityInput);
        input.clear();
        input.sendKeys("2");
    }
}


