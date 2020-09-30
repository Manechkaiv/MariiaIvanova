package hw3.ex2;

import hw3.ex2.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ServiceOptionsTest5_6 {

    WebDriver driver;

    public static HomePage homePage;

    SoftAssert softAssertion = new SoftAssert();

    //5. Click on "Service" subcategory in the header and check that drop down contains options
    @Test
    public void serviceOptions() {

        Assert.assertEquals(homePage.getHeaderMenu().getExistsServiceElements(), ConfProperties.getProperty("serviceOptionsHeader"));

    }

    //6. Click on Service subcategory in the left section and check that drop down contains options
    @Test
    public void serviceOptionsLeft() {

        Assert.assertEquals(homePage.getLeftMenu().getLeftServiceElements(), ConfProperties.getProperty("serviceOptionsLeft"));

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
