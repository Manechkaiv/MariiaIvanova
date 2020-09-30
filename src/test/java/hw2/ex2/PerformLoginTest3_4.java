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


public class PerformLoginTest3_4 {

    WebDriver driver;
    SoftAssert softassert = new SoftAssert();
    public static LoginPage loginPage;
    public static ProfilePage profilePage;

    //3. Perform login
    //4. Assert User name in the left-top side of screen that user is loggined
    @Test
    public void performLogCheckUsername() {

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
        softassert.assertEquals(userName, "ROMAN IOVLEV");
        softassert.assertAll();
    }


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        String baseUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        driver.get(baseUrl);

        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}