package StepDefinitions;

import Pages.ComparePage;
import Pages.HomePage;
import Pages.LaptopsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Laptop_StepDef {

    HomePage homePage = new HomePage(Hooks.driver);
    LaptopsPage laptopsPage = new LaptopsPage(Hooks.driver);
    ComparePage comparePage = new ComparePage(Hooks.driver);

    String oldUrl;

    @Given("the user is on the home page")
    public void userInHomePage(){
        Assert.assertEquals(homePage.getActualTitle(), homePage.getExpectedTitle());
    }

    @When("the user opens the Laptops page")
    public void theUserOpensTheLaptopsPage() {
        homePage.clickOnLaptops();
        laptopsPage = homePage.clickOnShowAllLaptops();
        Assert.assertEquals(laptopsPage.getActualTitle(), laptopsPage.getExpectedTitle());
    }

    @And("the user adds all laptop items to the cart")
    public void theUserAddsAllLaptopItemsToTheCart() {
        laptopsPage.addAllItemsToCart();
    }

    @And("the user sorts laptops by {string}")
    public void theUserSortsLaptopsBy(String arg0) {
        laptopsPage.selectSortOrder(arg0);
    }

    @Then("the laptops should appear sorted alphabetically from A to Z")
    public void theLaptopsShouldAppearSortedAlphabeticallyFromAToZ() {
        Assert.assertTrue(laptopsPage.isSortedByNameAZ(), "Laptops are not sorted correctly by Name A-Z.");
    }
    @And("the user clicks the compare button")
    public void theUserClicksTheCompareButton() {
        comparePage = laptopsPage.clickOnCompareButton();
    }

    @Then("the user should be redirected to the compare page")
    public void theUserShouldBeRedirectedToTheComparePage() {
        Assert.assertEquals(comparePage.getActualTitle(), comparePage.getExpectedTitle(),
                "User is not on the Compare page.");
    }
}
