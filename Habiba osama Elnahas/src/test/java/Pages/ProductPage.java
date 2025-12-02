package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    private By firstProduct = By.cssSelector(".product-layout .product-thumb:nth-child(1) a");
    private By addToWishlistBtn = By.cssSelector("button[data-original-title='Add to Wish List']");

    public ProductPage(WebDriver driver) { this.driver = driver; }

    public void openHome() { driver.get("https://demo.opencart.com/"); }

    public void openFirstProduct() { driver.findElement(firstProduct).click(); }

    public void addToWishlist() { driver.findElement(addToWishlistBtn).click(); }
}