package Tests;

import Pages.BaseTest.BaseTestClass;
import Pages.HomePage;
import Pages.PhonesIPDAsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PhoneIpadTest extends BaseTestClass {
    HomePage homePage;
    PhonesIPDAsPage phonesIPDAsPage;

    @Test
    public void ensurePhoneIpad() {
        // استخدام الـ driver و wait من BaseTestClass
        homePage = new HomePage(driver, wait); // لو HomePage محتاج WebDriverWait
        phonesIPDAsPage = homePage.clickPhonesIPDAs();

        // التأكد من الوصول لصفحة Phones & PDAs
        Assert.assertTrue(
                phonesIPDAsPage.getPageTitle().contains("Phones & PDAs"),
                "Navigation to Phones & PDAs page failed!"
        );

        // التأكد من وجود منتجات
        int count = phonesIPDAsPage.getProductsCount();
        Assert.assertTrue(count > 0, "No products found!");

        // ترتيب وعرض المنتجات
        phonesIPDAsPage.selectSortBy("Name (A - Z)");
        phonesIPDAsPage.selectShowLimit("3");

        // إضافة المنتج للعربة
        phonesIPDAsPage.clickAddToCart(0);

        // الانتظار حتى يظهر تحديث العربة
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("header-cart"), "1 item(s)")
        );

        // إضافة المنتج للقائمة المفضلة والمقارنة
        phonesIPDAsPage.clickAddToWishList(0);
        phonesIPDAsPage.clickAddToCompare(0);

        // التحقق من اسم وسعر المنتج
        String name = phonesIPDAsPage.getProductName(0).trim();
        String price = phonesIPDAsPage.getProductPrice(0).trim();

        Assert.assertNotNull(name, "Product name should not be null");
        Assert.assertFalse(name.isEmpty(), "Product name should not be empty");

        Assert.assertNotNull(price, "Product price should not be null");
        Assert.assertFalse(price.isEmpty(), "Product price should not be empty");
    }
}
