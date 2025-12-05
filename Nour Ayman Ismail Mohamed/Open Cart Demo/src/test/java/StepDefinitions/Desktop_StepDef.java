package StepDefinitions;

import Pages.ComparePage;
import Pages.DesktopsPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Desktop_StepDef {

    HomePage homePage = new HomePage(Hooks.driver);
    DesktopsPage desktopsPage = new DesktopsPage(Hooks.driver);
    ComparePage comparePage = new ComparePage(Hooks.driver);
    String oldUrl;

    @Given("the user is in the home page")
    public void userInHomePage(){
        Assert.assertEquals(homePage.getActualTitle(),homePage.getExpectedTitle());

    }

    @When("the user opens the Desktops page")
    public void theUserOpensTheDesktopsPage() {
        homePage.clickOnDesktops();
        desktopsPage = homePage.clickOnShowAllDesktops();
        Assert.assertEquals(desktopsPage.getActualTitle(),desktopsPage.getExpectedTitle());
    }

    @And("the user adds all desktop items to the cart")
    public void theUserAddsAllDesktopItemsToTheCart() {
        desktopsPage.addAllItemsToCart();
    }

    @Then("all items should be added successfully")
    public void allItemsShouldBeAddedSuccessfully() {
        int expectedProducts = desktopsPage.getAllAddToCartButtons().size();
        int actualProducts = desktopsPage.getCartItemCount();
        Assert.assertEquals(expectedProducts, actualProducts, "Not all items were added to the cart.");
    }

    @And("the user clicks the next page button")
    public void theUserClicksTheNextPageButton() {
        oldUrl = desktopsPage.getCurrentPageUrl();
        desktopsPage = desktopsPage.clickOnNextPage();
    }

    @Then("the page should navigate to a new URL")
    public void thePageShouldNavigateToANewURL() {
        String newUrl = desktopsPage.getCurrentPageUrl();
        Assert.assertNotEquals(newUrl, oldUrl, "The page did not navigate to a new URL.");
    }

    @And("the user clicks the compare button on the desktops page")
    public void theUserClicksTheCompareButton() {
        comparePage = desktopsPage.clickOnCompareButton();
    }

    @Then("the user should be redirected to the compare page from the desktops page")
    public void theUserShouldBeRedirectedToTheComparePage() {
        Assert.assertEquals(comparePage.getActualTitle(), comparePage.getExpectedTitle(),
                "User is not on the Compare page.");
    }
}
