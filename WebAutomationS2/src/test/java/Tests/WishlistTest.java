package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.WishlistPage;

public class WishlistTest extends BaseTest {

    @Test
    public void wishlistTest() {
        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        WishlistPage wishlist = new WishlistPage(driver);

        login.open();
        login.login("demo@demo.com", "demo");
        Assert.assertTrue(login.isLoggedIn(), "Login failed!");

        product.openHome();
        product.openFirstProduct();
        product.addToWishlist();

        wishlist.open();
        Assert.assertTrue(wishlist.hasItems(), "Wishlist is empty!");
    }
}