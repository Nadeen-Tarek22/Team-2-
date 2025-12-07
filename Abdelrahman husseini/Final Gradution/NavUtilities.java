package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavUtilities {
    WebDriver driver;

    public NavUtilities(WebDriver driver) {
        this.driver = driver;
    }

    By desktopPageLinkLocator= By.linkText("Show All Desktops");
    By laptopsPageLinkLocator= By.linkText("Show All Laptops & Notebooks");
    By allComponentsLinkLocator= By.linkText("Show All Components");
    By tabletsLinkLocator= By.linkText("Tablets");
    By softwareLinkLocator= By.linkText("Software");
    By phonesLinkLocator= By.linkText("Phones & PDAs");
    By cameraLinkLocator= By.linkText("Cameras");
    By mp3LinkLocator= By.linkText("Show All MP3 Players");

    public void clickOnDeskTopPage(){
        driver.findElement(desktopPageLinkLocator).click();

    }

    public void clickOnLaptopsPage(){
        driver.findElement(laptopsPageLinkLocator).click();

    }

    public void clickOnComponents(){
        driver.findElement(allComponentsLinkLocator).click();

    }

    public void clickOnTabletsPage(){
        driver.findElement(tabletsLinkLocator).click();

    }

    public void clickOnSoftwarePage(){
        driver.findElement(softwareLinkLocator).click();

    }

    public void clickOnPhonesPage(){
        driver.findElement(phonesLinkLocator).click();

    }

    public void clickOnCameraPage(){
        driver.findElement(cameraLinkLocator).click();
    }

    public void clickOnMp3Page(){
        driver.findElement(mp3LinkLocator).click();
    }




}
