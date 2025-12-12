package StepDefinitions;

import Pages.HomePage;
import Pages.TabletsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Tablets_StepDef {

    HomePage homePage = new HomePage(Hooks.driver);
    TabletsPage tabletsPage = new TabletsPage(Hooks.driver);
    String oldCount;

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        Assert.assertEquals(homePage.getActualTitle(), homePage.getExpectedTitle());
    }

    @When("the user opens the Tablets page")
    public void theUserOpensTheTabletsPage() {
        homePage.clickOnTablets();
        tabletsPage = homePage.clickOnShowAllTablets();
        Assert.assertEquals(tabletsPage.getActualTitle(), tabletsPage.getExpectedTitle());
    }

    @Then("all tablet products should display image, name and price")
    public void allTabletProductsShouldDisplayImageNameAndPrice() {
        Assert.assertTrue(tabletsPage.allProductsHaveImage(), "Some products are missing images.");
        Assert.assertTrue(tabletsPage.allProductsHaveName(), "Some products are missing names.");
        Assert.assertTrue(tabletsPage.allProductsHavePrice(), "Some products are missing prices.");
    }

    @And("the user clicks all Add to Cart buttons")
    public void theUserClicksAllAddToCartButtons() {
        tabletsPage.addAllItemsToCart();
    }

    @Then("the user should be able to add all tablets successfully")
    public void theUserShouldBeAbleToAddAllTabletsSuccessfully() {
        int expectedProducts = tabletsPage.getAllAddToCartButtons().size();
        int actualProducts = tabletsPage.getCartItemCount();
        Assert.assertEquals(expectedProducts, actualProducts, "Not all tablets were added to cart.");
    }

    @And("the user changes the product count")
    public void theUserChangesTheProductCount() {
        oldCount = tabletsPage.getCurrentProductCount();
        tabletsPage.changeProductCount();
    }

    @Then("the count should be updated correctly")
    public void theCountShouldBeUpdatedCorrectly() {
        String newCount = tabletsPage.getCurrentProductCount();
        Assert.assertNotEquals(newCount, oldCount, "The product count did not change.");
    }
}
