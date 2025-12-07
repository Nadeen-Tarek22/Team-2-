package Pages.Account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By privacyPolicy = By.xpath("//input[@name='agree']");
    By newsletterNo = By.xpath("//input[@name='newsletter' and @value='0']");
     By newsletterYes = By.xpath("//input[@name='newsletter' and @value='1']");
    By continueBtn = By.xpath("//button[contains(text(), 'Continue')]");
    By successMsg = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterFirstName(String text) {
     driver.findElement(firstName).sendKeys(text);
    }

    public void enterLastName(String text) {
        driver.findElement(lastName).sendKeys(text);
    }

    public void enterEmail(String text) {
        driver.findElement(email).sendKeys(text);
    }

    public void enterPhone(String text) {
        driver.findElement(telephone).sendKeys(text);
    }

    public void enterPassword(String text) {
        driver.findElement(password).sendKeys(text);
        driver.findElement(confirmPassword).sendKeys(text);
    }

    public void chooseNewsletterNo() {
        driver.findElement(newsletterNo).click();
    }

    public void chooseNewsletterYes() {
        driver.findElement(newsletterYes).click();
    }

    public void agreePrivacyPolicy() {
        driver.findElement(privacyPolicy).click();
    }

    public void clickContinue() {
      driver.findElement(continueBtn).click();
    }

    // 🔥 FULL METHOD — full registration
    public void registerUser(String fname, String lname, String email,
                             String phone, String pass) {

        enterFirstName(fname);
        enterLastName(lname);
        enterEmail(email);
        enterPhone(phone);
        enterPassword(pass);

        chooseNewsletterNo();
        agreePrivacyPolicy();
        clickContinue();
    }

    // ✔ Assertion support
    public boolean isAccountCreated() {
        return driver.findElement(successMsg).isDisplayed();
    }

}
