package hw2.ex2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class OpenUrlTest1 {

    WebDriver driver;

    //1. Open test site by URL
    @Test
    public void openURLTest() {

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

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