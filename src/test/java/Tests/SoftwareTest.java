package Tests;

import BaseTest.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftwareTest extends BaseTestClass {

    @Test
    public void ensureSoftware(){
        softwarePage = homePage.clickSoftware();

        Assert.assertEquals(softwarePage.getPageTitle(),"Software","Page title mismatch!");
        Assert.assertTrue(softwarePage.getEmptyMessage().contains("There are no products to list in this category."),"Empty category message not found!");
        Assert.assertTrue(softwarePage.isContinueButtonDisplayed(),"Continue button is missing!");

    }

}
