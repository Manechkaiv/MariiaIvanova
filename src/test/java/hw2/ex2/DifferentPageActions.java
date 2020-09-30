package hw2.ex2;

import hw2.ex1.LoginPage;
import hw2.ex1.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DifferentPageActions {

    WebDriver driver;
    SoftAssert softAssertion = new SoftAssert();
    public static LoginPage loginPage;
    public static ProfilePage profilePage;

    //8. Check interface on Different elements page, it contains all needed elements
    @Test
    public void differentPageEl() {

        WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div"));
        Actions action = new Actions(driver);

        action.moveToElement(element);

        //checking checkboxes
        int count = driver.findElements(By.className("label-checkbox")).size();
        softAssertion.assertEquals(count, 4);

        //checking radios
        count = driver.findElements(By.className("label-radio")).size();
        softAssertion.assertEquals(count, 4);


        //checking buttons
        count = driver.findElements(By.cssSelector("div[class='main-content-hg'] [class ='uui-button']")).size();
        softAssertion.assertEquals(count, 2);

        //checking dropdown
        count = driver.findElements(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select")).size();
        softAssertion.assertEquals(count, 1);

        softAssertion.assertAll();
    }

    //9. Assert that there is Right Section
    @Test
    public void differentPageRightSection() {

        WebElement element = driver.findElement(By.xpath("/html/body/div/div[3]"));
        softAssertion.assertTrue(element.isDisplayed());
        softAssertion.assertAll();
    }

    //10. Assert that there is Left Section
    @Test
    public void leftSection() {

        WebElement element = driver.findElement(By.xpath("//*[@id=\"mCSB_1\"]"));
        softAssertion.assertTrue(element.isDisplayed());
        softAssertion.assertAll();

    }

    //11. Select checkboxes
    @Test
    public void selectCheckBoxes() {

        WebElement element;
        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[1]/input"));

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until((ExpectedConditions.elementToBeClickable(element)));
        element.click();

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[3]/input"));
        wait.until((ExpectedConditions.elementToBeClickable(element)));
        element.click();

    }

    //12.Assert that for each checkbox there is an individual log row
    //and value is corresponded to the status of checkbox
    @Test
    public void individualLogStatusOfCheckbox() {

        WebElement elementRowFirst;
        WebElement checkBoxElementWater = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[1]/input"));
        WebElement checkBoxElementWind = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[3]/input"));
        checkBoxElementWater.click();

        elementRowFirst = driver.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/section[1]/div[2]/div/ul/li[1]"));

        softAssertion.assertTrue(elementRowFirst.getText().contains("true"));
        softAssertion.assertTrue(elementRowFirst.getText().contains(checkBoxElementWater.getText()));

        checkBoxElementWind.click();

        softAssertion.assertTrue(elementRowFirst.getText().contains("true"));
        softAssertion.assertTrue(elementRowFirst.getText().contains(checkBoxElementWind.getText()));

        softAssertion.assertAll();

    }

    //13. Select radio
    @Test
    public void selectRadio() {

        WebElement element = driver.findElement(By
                .xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/label[2]/input"));
        element.click();
    }

    //14. Assert that for radiobutton there is a log row
    // and value is corresponded to the status of radiobutton
    @Test
    public void radiobutton() {

        WebElement elementRowFirst;
        WebElement radioElement = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/label[2]/input"));

        radioElement.click();

        elementRowFirst = driver.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/section[1]/div[2]/div/ul/li[1]"));

        if (radioElement.isSelected()) {
            softAssertion.assertTrue(elementRowFirst.getText().contains(radioElement.getText()));
        }

        softAssertion.assertAll();


    }

    //15. Select in dropdown
    @Test
    public void selectDropdown() {

        WebElement element = driver.findElement(By
                .xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select"));
        element.click();

        driver.findElement(By
                .xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select/option[4]"));
        element.click();
    }


    //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
    @Test
    public void dropdownLogRow() {

        WebElement elementRowFirst;
        WebElement elementDropdownYellow = driver.findElement(By
                .xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select/option[4]"));
        WebElement dropDownElement = driver.findElement(By
                .xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select"));

        dropDownElement.click();
        elementDropdownYellow.click();

        elementRowFirst = driver.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/section[1]/div[2]/div/ul/li[1]"));

        if (elementDropdownYellow.isSelected()) {
            softAssertion.assertTrue(elementRowFirst.getText().contains(elementDropdownYellow.getText()));
        }

        softAssertion.assertAll();

    }

    //17. Unselect and assert checkboxes
    @Test
    public void unselectCheckboxes() {

        WebElement element;
        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[1]/input"));
        element.click();
        element.click();
        softAssertion.assertTrue(!element.isSelected());

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[3]/input"));
        element.click();
        element.click();
        softAssertion.assertTrue(!element.isSelected());
        softAssertion.assertAll();

    }

    //18. Assert that for each checkbox there is an individual log row
    // and value is corresponded to the status of checkbox.
    @Test
    public void eachCheckboxIndividualLog() {

        WebElement elementRowFirst;
        WebElement checkBoxElementWater = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[1]/input"));
        WebElement checkBoxElementWind = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/label[3]/input"));
        checkBoxElementWater.click();
        checkBoxElementWater.click();

        elementRowFirst = driver.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/section[1]/div[2]/div/ul/li[1]"));

        softAssertion.assertTrue(elementRowFirst.getText().contains("false"));
        softAssertion.assertTrue(elementRowFirst.getText().contains(checkBoxElementWater.getText()));

        checkBoxElementWind.click();
        checkBoxElementWind.click();

        elementRowFirst = driver.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/section[1]/div[2]/div/ul/li[1]"));

        softAssertion.assertTrue(elementRowFirst.getText().contains("false"));
        softAssertion.assertTrue(elementRowFirst.getText().contains(checkBoxElementWind.getText()));

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

        element = driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[3]/a"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[3]/ul/li[8]/a"));
        element.click();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
