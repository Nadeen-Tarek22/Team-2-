package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.TransactionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Transaction_StepDef {

    TransactionPage transactionPage = new TransactionPage(Hooks.driver);
    HomePage homePage = new HomePage(Hooks.driver);
    LoginPage loginPage = new LoginPage(Hooks.driver);
    MyAccountPage myAccountPage = new MyAccountPage(Hooks.driver);

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        homePage.clickOnMyAccount();
        loginPage = homePage.clickOnLogin();

        Assert.assertTrue(loginPage.getActualTitle().trim().contains(loginPage.getExpectedTitle()));
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        loginPage.setEmail();
        loginPage.setPassword();

    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        myAccountPage = loginPage.clickOnLoginButton();
    }

    @And("the user navigates to the Transactions page")
    public void theUserNavigatesToTheTransactionsPage() {
        myAccountPage.clickOnTransactionLink();
    }

    @Then("the Transactions page title should be displayed correctly")
    public void theTransactionsPageTitleShouldBeDisplayedCorrectly() {
        Assert.assertEquals(transactionPage.getActualTitle(),transactionPage.getExpectedTitle(),"The Title doesn't match ");
    }

    @And("the transactions table should be visible")
    public void theTransactionsTableShouldBeVisible() {
        Assert.assertTrue(transactionPage.isTableDisplayed(),"The Transactions Table is not shown");
    }

}
