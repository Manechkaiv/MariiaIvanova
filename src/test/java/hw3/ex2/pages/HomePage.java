package hw3.ex2.pages;

import hw3.ex1.ConfProperties;
import hw3.ex2.components.HeaderMenu;
import hw3.ex2.components.LeftMenu;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;

    private LeftMenu leftMenu;
    private HeaderMenu headerMenu;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
        leftMenu = new LeftMenu(driver);
    }

    @FindBy(xpath = "/html/body/header/div/nav/ul[2]/li/a")
    private WebElement menuLogin;
    /**
     * определение локатора поля ввода логина
     */
    @FindBy(xpath = "//*[@id='name']")
    private WebElement loginField;
    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement loginBtn;
    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwdField;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']")
    private WebElement headerItems;

    @FindBy(className = "benefit-icon")
    private List<WebElement> indexPageImages;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textBelowIndexPageImages;

    @FindBy(name = "main-title")
    private WebElement textMainHeader;

    @FindBy(name = "jdi-text")
    private WebElement jdiText;

    @FindBy(id = "second_frame")
    private WebElement centerIframe;

    @FindBy(xpath = "//*[@id=\\\"epam-logo\\\"]")
    private WebElement logo;

    @FindBy(xpath = "/html/body/div/div[2]/main/div[2]/h3[2]/a")
    private WebElement subHeaderText;

    @FindBy(xpath = "//*[@id=\"mCSB_1\"]")
    private WebElement leftSection;

    @FindBy(xpath = "/html/body/footer/div/div/div")
    private WebElement footer;

    public void login(String login, String passwd) {
        menuLogin.click();
        loginField.sendKeys(login);
        passwdField.sendKeys(passwd);
        loginBtn.click();
    }

    public void open() {
        driver.get(ConfProperties.getProperty("loginpage"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String title() {
        return driver.getTitle();
    }

    public String getTextHeaderItems() {
        return headerItems.getText();
    }

    public int getImageCount() {
        return indexPageImages.size();
    }

    public boolean isTextBelowImages() {
        for (int i = 0; i < indexPageImages.size(); i++) {
            Point placeImg = indexPageImages.get(i).getLocation();
            Point placeText = textBelowIndexPageImages.get(i).getLocation();
            if (placeImg.getY() > placeText.getY()) {
                return false;
            }
        }
        return true;
    }

    public String getTextMainHeader() {
        return textMainHeader.getText();
    }

    public String getTextMainHeaderJDI() {
        return jdiText.getText();
    }

    public boolean isIframeCenterExist() {
        if (centerIframe != null) {
            return true;
        }
        return false;
    }

    public boolean epamLogoLeftTopExist() {
        driver.switchTo().frame(2);
        if (logo != null) {
            return true;
        }
        return false;
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    public String getSubHeaderText() {
        return subHeaderText.getText();
    }

    public boolean isJDIGITHUBDisplayed() {
        return subHeaderText.isDisplayed();
    }


    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public boolean isLeftSectionExists() {
        return leftSection != null;
    }

    public boolean isFooterExists() {
        return footer != null;
    }

    public void closeBrowser() {
        driver.close();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }
}

