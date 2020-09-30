package hw3.ex1.six_twelve;

import hw3.ex1.ConfProperties;
import hw3.ex1.HomePage;
import hw3.ex1.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;


public class TestCheckTextsImages {

    private WebDriver driver;
    public static ProfilePage profilePage;
    public static HomePage homePage;

    //6. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test
    public void assertTextItemsHeader() {

        assertEquals(homePage.getTextHeaderItems(), ConfProperties.getProperty("headerMenuTexts"));

    }

    //7. Assert that there are 4 images on the Index Page and they are displayed
    @Test
    public void fourImagesTest() {

        assertEquals(homePage.getImageCount(), Integer.parseInt(ConfProperties.getProperty("imgCount")));

    }

    //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test
    public void fourTextsUnderImagesTest() {

        Assert.assertTrue(homePage.isTextBelowImages());

    }

    //9. Assert a text of the main headers
    @Test
    public void textMainHeaderTest() {
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(homePage.getTextMainHeader(), ConfProperties.getProperty("textMainHeader"));
        softAssertion.assertEquals(homePage.getTextMainHeaderJDI(), ConfProperties.getProperty("textMainHeaderJDI"));
        softAssertion.assertAll();
    }

    //10. Assert that there is the iframe in the center of page
    @Test
    public void iframeTest() {

        Assert.assertTrue(homePage.isIframeCenterExist());

    }


    //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
    @Test
    public void iframeSwitch() {

        Assert.assertTrue(homePage.epamLogoLeftTopExist());

    }


    //12. Switch to original window back
    @Test
    public void originalWindowTest() {

        homePage.switchToOriginalWindow();

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