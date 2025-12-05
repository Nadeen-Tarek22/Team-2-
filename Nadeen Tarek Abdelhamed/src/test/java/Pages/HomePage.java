package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v136.storage.model.AttributionReportingSourceRegistrationTimeConfig;

public class HomePage {
 WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

 By searchBarLocator= By.xpath("//input[@class='form-control form-control-lg']");
 By searchBarButtonLocator= By.xpath("//button[@class='btn btn-light btn-lg']");
 By mackBookProductLocator= By.linkText("MacBook"); // has 3 other with the same word but i think it will work
 By iPhoneProductLocator= By.linkText("iPhone"); //same as the previous
 String expectedHomeTitle= "Your Store";
 By actualHomeTitle= By.cssSelector("img[title='Your Store']");

public String getExpectedHomeTitle(){
    return expectedHomeTitle;
}

public String getActualHomeTitle(){
    return driver.findElement(actualHomeTitle).getText();
}

    public void setKeyWord(String keyWord) {
        driver.findElement(searchBarLocator).sendKeys(keyWord);
    }

    public SearchPage clickOnSearchButton(){
    driver.findElement(searchBarButtonLocator).click();
    return new SearchPage(driver);
    }

    public IphonePage clickOnIphoneProductButton(){
        driver.findElement(iPhoneProductLocator).click();
        return new IphonePage(driver);
    }





}
