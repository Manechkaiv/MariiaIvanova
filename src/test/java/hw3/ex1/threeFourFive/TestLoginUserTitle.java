package hw3.ex1.threeFourFive;

import hw3.ex1.ConfProperties;
import hw3.ex1.HomePage;
import hw3.ex1.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestLoginUserTitle {

    public static ProfilePage profilePage;
    public static HomePage homePage;
    public static WebDriver driver;


    // 3. perform login
    // 4. Assert User name in the left-top side of screen that user is loggined
    // 5. Assert browser title
    @Test
    public void performLogUsername() {

        SoftAssert softAssertion = new SoftAssert();

        homePage.login(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));
        softAssertion.assertEquals(profilePage.getUserName(), ConfProperties.getProperty("userName"));
        softAssertion.assertEquals(profilePage.title(), ConfProperties.getProperty("browserTitle"));

        softAssertion.assertAll();
    }

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        profilePage = new ProfilePage(driver);
        homePage = new HomePage(driver);

        homePage.open();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}