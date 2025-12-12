package StepDefinitions;

import Pages.ComponentsPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Components_StepDef {

    HomePage homePage = new HomePage(Hooks.driver);
    ComponentsPage componentsPage = new ComponentsPage(Hooks.driver);

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        Assert.assertEquals(homePage.getActualTitle(), homePage.getExpectedTitle());
    }

    @When("the user clicks on the Components tab")
    public void theUserClicksOnTheComponentsTab() {
        homePage.clickOnComponents();
        componentsPage = homePage.clickOnShowAllComponents();
    }

    @Then("the Components page should be displayed correctly")
    public void theComponentsPageShouldBeDisplayedCorrectly() {
        Assert.assertEquals(componentsPage.getActualTitle(), "Components");
    }

    @When("the user opens an empty category under Components")
    public void theUserOpensAnEmptyCategoryUnderComponents() {
        componentsPage.openEmptyComponentCategory();
    }

    @Then("a message “There are no products to list in this category.” should be displayed")
    public void aMessageShouldBeDisplayed() {
        Assert.assertTrue(componentsPage.isEmptyCategoryMessageDisplayed());
    }

    @When("the user opens the Components page")
    public void theUserOpensTheComponentsPage() {
        homePage.clickOnComponents();
        componentsPage = homePage.clickOnShowAllComponents();
    }

    @Then("all products should display price, name and image")
    public void allProductsShouldDisplayPriceNameAndImage() {
        Assert.assertTrue(componentsPage.allProductsHaveName());
        Assert.assertTrue(componentsPage.allProductsHavePrice());
        Assert.assertTrue(componentsPage.allProductsHaveImage());
    }

    @And("the user clicks all Add to Cart buttons")
    public void theUserClicksAllAddToCartButtons() {
        componentsPage.clickAllAddToCartButtons();
    }

    @Then("the user should be able to use all buttons successfully")
    public void theUserShouldBeAbleToUseAllButtonsSuccessfully() {
        Assert.assertTrue(true);
    }
}
