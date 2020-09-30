package hw3.ex2;

import hw3.ex2.ConfProperties;
import hw3.ex2.pages.ProfilePage;
import hw3.ex2.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;


public class PerformLoginTest3_4 {

    WebDriver driver;
    public static ProfilePage profilePage;
    public static HomePage homePage;

    //3. Perform login
    //4. Assert User name in the left-top side of screen that user is loggined
    @Test
    public void performLogCheckUsername() {

        homePage.login(ConfProperties.getProperty("login"), hw3.ex1.ConfProperties.getProperty("password"));
        assertEquals(profilePage.getUserName(), hw3.ex1.ConfProperties.getProperty("userName"));

    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);

        homePage.open();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}