package StepDefinitions;

import Pages.HomePage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Home_StepDef {
    HomePage homePage = new HomePage(Hooks.driver);
    SearchPage searchPage = new SearchPage(Hooks.driver);
@Given("user in home page")
    public void userInHomePage(){
    Wait<WebDriver> fluentWait  = new FluentWait<>(Hooks.driver)
            .withTimeout(Duration.ofSeconds(20))
            .ignoring(NoSuchElementException.class)
            .pollingEvery(Duration.ofSeconds(2));
    //Assert.assertTrue(homePage.getActualHomeTitle().contains(homePage.getExpectedHomeTitle()));
    System.out.println(homePage.getActualHomeTitle());
}

@When("user enter a {string} in search bar")
    public void enterSearchWord(String searchWord){
    Wait<WebDriver> fluentWait  = new FluentWait<>(Hooks.driver)
            .withTimeout(Duration.ofSeconds(20))
            .ignoring(NoSuchElementException.class)
            .pollingEvery(Duration.ofSeconds(2));
    homePage.setKeyWord(searchWord);
}

@Then("user is directed to search page")
     public void userDirectedToSearchPage(){

    //Assert.assertTrue(searchPage.getActualSearchTitle().contains(searchPage.getExpectedSearchTitle()));
    System.out.println("yes");

}

@When("user click on search bar icon")
    public void clickOnSearchIcon(){
    Wait<WebDriver> fluentWait  = new FluentWait<>(Hooks.driver)
            .withTimeout(Duration.ofSeconds(20))
            .ignoring(NoSuchElementException.class)
            .pollingEvery(Duration.ofSeconds(2));
    homePage.clickOnSearchButton();
}

@Then("Verify results Related {string}")
    public void VerifyResult(String keyWord){
    Wait<WebDriver> fluentWait  = new FluentWait<>(Hooks.driver)
            .withTimeout(Duration.ofSeconds(20))
            .ignoring(NoSuchElementException.class)
            .pollingEvery(Duration.ofSeconds(2));
    List<WebElement> elements= searchPage.ensureSearchResult();
    boolean exist=false;
    for(WebElement element: elements){
        if(element.getText().toLowerCase().contains(keyWord)){
            exist=true;
        }
        else {continue;}
    }
    Assert.assertTrue(exist);

}


    @Then("No products message appear")
    public void noProductsMessageAppear() {
        Wait<WebDriver> fluentWait  = new FluentWait<>(Hooks.driver)
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(2));
     Assert.assertTrue(searchPage.getActualResultMessageOfSearch().contains(searchPage.getExpectedMessageOfSearch()));
    }
}
