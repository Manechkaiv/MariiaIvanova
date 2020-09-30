package hw3.ex2;

import hw3.ex2.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DifferentElPageTest7 {

    WebDriver driver;

    public static HomePage homePage;

    //7. Open through the header menu Service -> Different Elements Page
    @Test
    public void serviceDifferentPage() {

        homePage.getHeaderMenu().openDifferentElementsPage();

    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        homePage.open();
        homePage.login(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
