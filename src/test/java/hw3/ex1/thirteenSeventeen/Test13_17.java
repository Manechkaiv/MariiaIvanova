package hw3.ex1.thirteenSeventeen;

import hw3.ex1.ConfProperties;
import hw3.ex1.HomePage;
import hw3.ex1.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test13_17 {

    private WebDriver driver;
    public static ProfilePage profilePage;
    public static HomePage homePage;

    //13. Assert a text of the sub header
    @Test
    public void subHeaderTest() {

        assertEquals(homePage.getSubHeaderText(), ConfProperties.getProperty("subHeaderText"));

    }

    //14. Assert that JDI GITHUB is a link and has a proper URL
    @Test
    public void GITHUBLink() {

        SoftAssert softAssertion = new SoftAssert();

        softAssertion.assertTrue(homePage.isJDIGITHUBDisplayed());
        softAssertion.assertEquals(homePage.getCurrentURL(), ConfProperties.getProperty("loginpage"));

        softAssertion.assertAll();

    }

    //15. Assert that there is Left Section
    @Test
    public void leftSection() {

        assertTrue(homePage.isLeftSectionExists());

    }

    //16. Assert that there is Footer
    @Test
    public void footerTest() {

        assertTrue(homePage.isFooterExists());

    }


    //17. Close Browser
    @Test
    public void closeBrowser() {

        homePage.closeBrowser();

    }

    @BeforeClass
    public void beforeClass() {
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