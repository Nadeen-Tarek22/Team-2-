package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LaptopsPage {

    WebDriver driver;

    public LaptopsPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCartLocator = By.cssSelector("button[aria-label='Add to Cart']");
    String expectedTitle = "Laptops & Notebooks";
    By actualTitleLocator = By.xpath("//h1[contains(text(),'Laptops & Notebooks')]");
    By productNameLocator = By.cssSelector(".product-thumb h4 a");
    By sortDropdown = By.id("input-sort");
    By compareButtonLocator= By.xpath("//span[text()='Product Compare (0)']");


    public void selectSortOrder(String visibleText) {
        Select sort = new Select(driver.findElement(sortDropdown));
        sort.selectByVisibleText(visibleText);
    }


    public List<String> getDisplayedProductNames() {
        List<WebElement> elements = driver.findElements(productNameLocator);
        List<String> names = new ArrayList<>();

        for (WebElement e : elements) {
            names.add(e.getText().trim());
        }
        return names;
    }


    public boolean isSortedByNameAZ() {
        List<String> uiList = getDisplayedProductNames();
        List<String> sortedCopy = new ArrayList<>(uiList);

        Collections.sort(sortedCopy);

        return uiList.equals(sortedCopy);
    }

    public void addAllItemsToCart(){
        List<WebElement> addToCart = driver.findElements(addToCartLocator);

        for(WebElement button : addToCart) {
            button.click();
        }
    }

    public String getExpectedTitle(){
        return expectedTitle;
    }

    public String getActualTitle(){
        return driver.findElement(actualTitleLocator).getText();
    }
    public ComparePage clickOnCompareButton(){
        driver.findElement(compareButtonLocator).click();
        return new ComparePage(driver);
    }

    public List<WebElement> getAllAddToCartButtons() {
        return driver.findElements(addToCartLocator);
    }
}
