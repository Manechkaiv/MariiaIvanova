package hw3.ex1.firstTwo;

import hw3.ex1.ConfProperties;
import hw3.ex1.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOpenTitle {

    private WebDriver driver;
    public static HomePage homePage;

    // 1. Open test site by URL
    @Test
    public void openUrlTest() {

        homePage.open();

    }

    // 2. Assert Browser title
    @Test
    public void checkTitle() {

        homePage.open();
        Assert.assertEquals(homePage.title(), ConfProperties.getProperty("browserTitle"));

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

