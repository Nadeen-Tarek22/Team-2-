package StepDefinitions;

import Pages.HomePage;
import Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Register_StepDef {

    HomePage homePage = new HomePage(Hooks.driver);
    RegisterPage registerPage = new RegisterPage(Hooks.driver);

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        Assert.assertEquals(homePage.getActualTitle(), homePage.getExpectedTitle());
    }

    @When("the user opens the Register page")
    public void theUserOpensTheRegisterPage() {
        homePage.clickOnMyAccount();
        registerPage = homePage.clickOnRegister();
    }

    @And("the user submits the form with blank personal details")
    public void theUserSubmitsTheFormWithBlankPersonalDetails() {
        registerPage.clickContinue();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(registerPage.isErrorMessageDisplayed());
    }

    @And("the user types in the password field")
    public void theUserTypesInThePasswordField() {
        registerPage.enterPassword("TestPassword123");
    }

    @Then("the characters should be hidden")
    public void theCharactersShouldBeHidden() {
        Assert.assertEquals(registerPage.getPasswordFieldType(), "password");
    }

    @And("the user enters valid registration credentials")
    public void theUserEntersValidRegistrationCredentials() {
        registerPage.enterFirstName("shimaa");
        registerPage.enterLastName("Abdelghani");
        registerPage.enterEmail("simaa" + System.currentTimeMillis() + "@test.com");
        registerPage.enterPassword("S@123456");
        registerPage.acceptPrivacyPolicy();
    }

    @Then("the system should accept the registration successfully")
    public void theSystemShouldAcceptTheRegistrationSuccessfully() {
        registerPage.clickContinue();
        Assert.assertTrue(registerPage.isRegistrationSuccessful());
    }
}
