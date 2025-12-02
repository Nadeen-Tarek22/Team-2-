package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchElementsLocator= By.xpath("//div[@class='product-thumb']//h4//a");
   // String keyWord= "mac";
    String expectedSearchTitle= "Search";
    By actualSearchPageTitle= By.tagName("h1");
    By noProductsLocator= By.xpath("//div[@class='col']//p");
    String noProductMessage= "no product";


    public String getExpectedSearchTitle(){
        return expectedSearchTitle;
    }

    public String getActualSearchTitle() {
        return driver.findElement(actualSearchPageTitle).getText();
    }



    public List<WebElement> ensureSearchResult(){

        List<WebElement> searchElements = driver.findElements(searchElementsLocator);
        return searchElements;

    }

    public String getActualResultMessageOfSearch(){
        return driver.findElement(noProductsLocator).getText();
    }

    public String getExpectedMessageOfSearch(){
        return noProductMessage;
    }




}
