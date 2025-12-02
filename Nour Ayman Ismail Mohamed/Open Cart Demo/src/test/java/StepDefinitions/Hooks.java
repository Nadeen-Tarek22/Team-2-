package StepDefinitions;

import Pages.ComparePage;
import Pages.DesktopsPage;
import Pages.HomePage;
import Pages.LaptopsPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class Hooks {

    public static WebDriver driver;


    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost/opencart/");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
