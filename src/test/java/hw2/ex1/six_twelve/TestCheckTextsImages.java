package hw2.ex1.six_twelve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TestCheckTextsImages {

    private WebDriver driver;


    //6. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test
    public void fourItems() {
        WebElement elementHeader;
        //элемент верхнего меню
        elementHeader = driver.findElement(By.xpath("/html/body/header/div"));

        int leftTopX = elementHeader.getLocation().getX();
        int leftTopY = elementHeader.getLocation().getY();
        int height = elementHeader.getSize().height;
        int width = elementHeader.getSize().width;
        int leftDown = leftTopY + height;
        int rightDown = leftTopX + width;

        WebElement element = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[1]/a"));
        assertEquals(element.getText(), "HOME");
        Assert.assertTrue(element.isDisplayed());

        //проверка на то, что оно находится в области меню по нижнему правому краю
        int leftTopXText = element.getLocation().getX();
        int leftTopYText = element.getLocation().getY();
        int heightText = element.getSize().height;
        int widthText = element.getSize().width;
        int leftDownText = leftTopYText + heightText;
        int rightDownText = leftTopXText + widthText;
        Assert.assertTrue(leftDownText <= leftDown && rightDownText <= rightDown);


        element = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[2]/a"));
        assertEquals(element.getText(), "CONTACT FORM");
        Assert.assertTrue(element.isDisplayed());

        leftTopXText = element.getLocation().getX();
        leftTopYText = element.getLocation().getY();
        heightText = element.getSize().height;
        widthText = element.getSize().width;
        leftDownText = leftTopYText + heightText;
        rightDownText = leftTopXText + widthText;
        Assert.assertTrue(leftDownText <= leftDown && rightDownText <= rightDown);

        element = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[3]/a"));
        assertEquals(element.getText(), "SERVICE");
        Assert.assertTrue(element.isDisplayed());

        leftTopXText = element.getLocation().getX();
        leftTopYText = element.getLocation().getY();
        heightText = element.getSize().height;
        widthText = element.getSize().width;
        leftDownText = leftTopYText + heightText;
        rightDownText = leftTopXText + widthText;
        Assert.assertTrue(leftDownText <= leftDown && rightDownText <= rightDown);

        element = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[4]/a"));
        assertEquals(element.getText(), "METALS & COLORS");
        Assert.assertTrue(element.isDisplayed());

        leftTopXText = element.getLocation().getX();
        leftTopYText = element.getLocation().getY();
        heightText = element.getSize().height;
        widthText = element.getSize().width;
        leftDownText = leftTopYText + heightText;
        rightDownText = leftTopXText + widthText;
        Assert.assertTrue(leftDownText <= leftDown && rightDownText <= rightDown);
    }

    //7. Assert that there are 4 images on the Index Page and they are displayed
    @Test
    public void fourImagesTest() {
        WebElement element;

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[1]/div/div/span"));
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[2]/div/div/span"));
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[3]/div/div/span"));
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[4]/div/div/span"));
        Assert.assertTrue(element.isDisplayed());
    }

    //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test
    public void fourTextsUnderImagesTest() {
        WebElement element;

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[1]/div/span"));
        assertEquals(element.getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[2]/div/span"));
        assertEquals(element.getText(), "To be flexible and\n" +
                "customizable");
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[3]/div/span"));
        assertEquals(element.getText(), "To be multiplatform");
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[4]/div/span"));
        assertEquals(element.getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
        Assert.assertTrue(element.isDisplayed());

    }

    //9. Assert a text of the main headers
    @Test
    public void textMainHeaderTest() {

        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/h3[1]"));
        assertEquals(element.getText(), "EPAM FRAMEWORK WISHES…");
        Assert.assertTrue(element.isDisplayed());

        element = driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/p"));
        Assert.assertTrue(element.isDisplayed());
        wait.until(ExpectedConditions.textToBePresentInElement(element, "LOREM IPSUM"));
    }

    //10. Assert that there is the iframe in the center of page
    @Test
    public void iframeTest() {

        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 5);

        element = driver.findElement(By.name("second_frame"));
        wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
    }


    //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
    @Test
    public void iframeSwitch() {

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.switchTo().frame(2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"epam-logo\"]")));

    }


    //12. Switch to original window back
    @Test
    public void originalWindowTest() {

        driver.switchTo().defaultContent();

        //switchTo().innerFrame(“parentFrame”, “childFrame_1”);
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