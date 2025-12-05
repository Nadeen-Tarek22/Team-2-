package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.WishlistPage;
import Pages.CartPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        WishlistPage wishlist = new WishlistPage(driver);
        CartPage cart = new CartPage(driver);

        login.open();
        login.login("demo@demo.com", "demo");
        Assert.assertTrue(login.isLoggedIn(), "Login failed!");

        product.openHome();
        product.openFirstProduct();
        product.addToWishlist();

        wishlist.open();
        Assert.assertTrue(wishlist.hasItems(), "Wishlist is empty!");
        wishlist.addFirstWishlistItemToCart();

        cart.openCart();
        cart.checkout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "Checkout page did not open!");
    }
}