package BaseTest;

import Pages.HomePage;
import Pages.PhonesIPDAsPage;
import Pages.SoftwarePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected HomePage homePage;
    protected SoftwarePage softwarePage;
    protected PhonesIPDAsPage phonesIPDAsPage;

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.navigate().to("https://demo.opencart.com/");

        homePage = new HomePage(driver, wait);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
