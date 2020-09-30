package hw3.ex2;

import hw3.ex2.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class VerifyTitleTest2 {

    private WebDriver driver;
    public static HomePage homePage;

    //2. Assert Browser title
    @Test
    public void verifyTitle() {

        Assert.assertEquals(homePage.title(), ConfProperties.getProperty("browserTitle"));

    }

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        homePage.open();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}