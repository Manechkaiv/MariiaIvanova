package hw2.ex1.firstTwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestOpenTitle {

    private WebDriver driver;

    // 1. Open test site by URL
    // 2. Assert Browser title
    @Test
    public void checkTitle() {
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();

        // launch Chrome and direct it to the Base URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}