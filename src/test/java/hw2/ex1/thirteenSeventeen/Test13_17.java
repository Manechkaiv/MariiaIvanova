package hw2.ex1.thirteenSeventeen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test13_17 {

    private WebDriver driver;

    //13. Assert a text of the sub header
    @Test
    public void subHeaderTest() {

        WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/h3[2]/a"));
        assertEquals(element.getText(), "JDI GITHUB");

    }

    //14. Assert that JDI GITHUB is a link and has a proper URL
    @Test
    public void GITHUBLink() {

        String url = "https://jdi-testing.github.io/jdi-light/index.html";

        WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/h3[2]/a"));
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.elementToBeClickable(element));
        assertEquals(driver.getCurrentUrl(), url);
    }

    //15. Assert that there is Left Section
    @Test
    public void leftSection() {

        WebElement element = driver.findElement(By.xpath("//*[@id=\"mCSB_1\"]"));
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));

    }

    //16. Assert that there is Footer
    @Test
    public void footerTest() {

        WebElement element = driver.findElement(By.xpath("/html/body/footer/div/div/div"));
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));

    }


    //17. Close Browser
    @Test
    public void closeBrowser() {

        driver.close();

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