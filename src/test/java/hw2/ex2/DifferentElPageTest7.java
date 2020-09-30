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


public class DifferentElPageTest7 {

    WebDriver driver;
    SoftAssert softAssertion = new SoftAssert();
    public static LoginPage loginPage;
    public static ProfilePage profilePage;

    //7. Open through the header menu Service -> Different Elements Page
    @Test
    public void serviceDifferentPage() {

        WebElement element = driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[3]/a"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[3]/ul/li[8]/a"));
        element.click();

        softAssertion.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/different-elements.html");
        softAssertion.assertAll();
    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("/html/body/header/div/nav/ul[2]/li/a"));
        element.click();
        //нажимаем кнопку логина
        loginPage.clickLoginBtn();
        loginPage.inputLogin("Roman");
        //вводим пароль
        loginPage.inputPasswd("Jdi1234");
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
