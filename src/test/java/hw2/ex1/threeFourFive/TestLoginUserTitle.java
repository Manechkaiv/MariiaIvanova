package hw2.ex1.threeFourFive;

import hw2.ex1.ConfProperties;
import hw2.ex1.LoginPage;
import hw2.ex1.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class TestLoginUserTitle {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {


        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    // 3. perform login
    // 4. Assert User name in the left-top side of screen that user is loggined
    // 5. Assert browser title
    @Test
    public void performLogUsername() {

        //открываем меню
        WebElement element = driver.findElement(By.xpath("/html/body/header/div/nav/ul[2]/li/a"));
        element.click();
        //нажимаем кнопку логина
        loginPage.clickLoginBtn();
        loginPage.inputLogin("Roman");
        //вводим пароль
        loginPage.inputPasswd("Jdi1234");
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        String userName = profilePage.getUserName();
        //и сравниваем его с логином
        Assert.assertEquals(userName, "ROMAN IOVLEV");
        assertEquals(driver.getTitle(), "Home Page");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}