package Tests;

import Pages.BaseTest.BaseTestClass;
import Pages.HomePage;
import Pages.SoftwarePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SoftwareTest extends BaseTestClass {

    @Test
    public void ensureSoftware() {

        // استخدام driver و wait من BaseTestClass
        HomePage homePage = new HomePage(driver, wait); // لو HomePage محتاج WebDriverWait
        SoftwarePage softwarePage = homePage.clickSoftwarePage();

        // Assertions
        Assert.assertEquals(softwarePage.getPageTitle(), "Software", "Page title mismatch!");
        Assert.assertTrue(softwarePage.getEmptyMessage().contains(
                        "There are no products to list in this category."),
                "Empty category message not found!"
        );
        Assert.assertTrue(softwarePage.isContinueButtonDisplayed(), "Continue button is missing!");
    }

}
