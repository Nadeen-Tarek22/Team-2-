package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    private By cartLink = By.id("cart");
    private By viewCartLink = By.xpath("//strong[text()=' View Cart']");
    private By checkoutBtn = By.xpath("//a[text()='Checkout']");

    public CartPage(WebDriver driver) { this.driver = driver; }

    public void openCart() {
        driver.findElement(cartLink).click();
        driver.findElement(viewCartLink).click();
    }

    public void checkout() { driver.findElement(checkoutBtn).click(); }
}