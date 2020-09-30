package hw2.ex2;

import hw2.ex1.LoginPage;
import hw2.ex1.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTitleTest2 {

    WebDriver driver;
    SoftAssert softassert = new SoftAssert();

    //2. Assert Browser title
    @Test
    public void verifyTitle() {
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //Soft assert applied to verify title
        softassert.assertEquals(driver.getTitle(), "Home Page");
        softassert.assertAll();

    }

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();

        String baseUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        driver.get(baseUrl);

        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}