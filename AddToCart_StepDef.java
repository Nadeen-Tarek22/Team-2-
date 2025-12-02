package StepDefinitions;

import Pages.HomePage;
import Pages.IphonePage;
import Pages.ShoppingCartPage;
import io.cucumber.java.en.And;
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

public class AddToCart_StepDef {

    HomePage homePage = new HomePage(Hooks.driver);
    IphonePage iphonePage= new IphonePage(Hooks.driver);
    ShoppingCartPage cartPage= new ShoppingCartPage(Hooks.driver);

    @When("clicking on iphone product")
    public void clickOnIphoneProduct(){
        Wait<WebDriver> fluentWait  = new FluentWait<>(Hooks.driver)
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(2));
        homePage.clickOnIphoneProductButton();
    }

    @And("clicking on add to cart button")
    public void clickOnCart(){
        Wait<WebDriver> fluentWait  = new FluentWait<>(Hooks.driver)
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(2));
        iphonePage.addToCart();
    }

    @Then("alert successfully appear")
    public void compareAlerts(){
        Wait<WebDriver> fluentWait  = new FluentWait<>(Hooks.driver)
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(2));
        boolean temp;
        if (iphonePage.getActualTextOfAlert().contains(iphonePage.getExpectedTextOfAlert())){
            temp=true;
        }
        else{ temp=false;}
        Assert.assertTrue(temp);
    }

    @When("clicking on view cart")
    public void clickOnViewCart(){
        Wait<WebDriver> fluentWait  = new FluentWait<>(Hooks.driver)
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(2));
        iphonePage.clickOnGeneralButtonOfCart();
    }

    @Then("user is directed to shopping cart page")
    public void ensureShoppingCartPage(){
        Wait<WebDriver> fluentWait  = new FluentWait<>(Hooks.driver)
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(2));
        boolean temp;
        if(cartPage.actualShoppingCartUrl().contains(cartPage.getShoppingCartUrl())){
            temp=true;
        }
        else {temp=false;}
        Assert.assertTrue(temp);
    }


    @And("iphone is existed in elements in cart page")
    public void iphoneExistInCart(){
        Wait<WebDriver> fluentWait  = new FluentWait<>(Hooks.driver)
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(2));
        List<WebElement> elements= cartPage.checkElementInCart();
        boolean exist=false;
        for(WebElement element: elements){
            if(element.getText().toLowerCase().contains("iphone")){
                exist=true;
            }
            else {continue;}
        }
        Assert.assertTrue(exist);


    }
}
