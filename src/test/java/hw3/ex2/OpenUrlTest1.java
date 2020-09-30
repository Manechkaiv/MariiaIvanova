package hw3.ex2;

import hw3.ex2.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class OpenUrlTest1 {

    WebDriver driver;
    public static HomePage homePage;

    //1. Open test site by URL
    @Test
    public void openURLTest() {

        homePage.open();

    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        homePage = new HomePage(driver);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
