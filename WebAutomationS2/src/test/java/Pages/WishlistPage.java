package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
    WebDriver driver;
    private By wishlistItems = By.cssSelector(".table-responsive .product-thumb");
    private By addToCartBtn = By.xpath("//a[text()='Add to Cart']");

    public WishlistPage(WebDriver driver) { this.driver = driver; }

    public void open() { driver.get("https://demo.opencart.com/index.php?route=account/wishlist"); }

    public boolean hasItems() { return driver.findElements(wishlistItems).size() > 0; }

    public void addFirstWishlistItemToCart() { driver.findElement(addToCartBtn).click(); }
}