package Tests;

import BaseTest.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhoneIpadTest extends BaseTestClass {

    @Test
    public void ensurePhoneIpad() {


        phonesIPDAsPage = homePage.clickPhonesIPDAs();


        Assert.assertTrue(
                phonesIPDAsPage.getPageTitle().contains("Phones & PDAs"),
                "Navigation to Phones & PDAs page failed!"
        );


        int count = phonesIPDAsPage.getProductsCount();
        Assert.assertTrue(count > 0, "No products found!");


        phonesIPDAsPage.selectSortBy("Name (A - Z)");
        phonesIPDAsPage.selectShowLimit("3");

        phonesIPDAsPage.clickAddToCart(0);


        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("header-cart"), "1 item(s)")
        );

        phonesIPDAsPage.clickAddToWishList(0);
        phonesIPDAsPage.clickAddToCompare(0);

        String name = phonesIPDAsPage.getProductName(0).trim();
        String price = phonesIPDAsPage.getProductPrice(0).trim();

        Assert.assertNotNull(name, "Product name should not be null");
        Assert.assertFalse(name.isEmpty(), "Product name should not be empty");

        Assert.assertNotNull(price, "Product price should not be null");
        Assert.assertFalse(price.isEmpty(), "Product price should not be empty");
    }
}
