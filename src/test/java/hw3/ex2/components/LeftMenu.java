package hw3.ex2.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftMenu {

    private WebDriver driver;

    public LeftMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]/ul/li[3]/a")
    private WebElement service;

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]/ul/li[3]/ul")
    private List<WebElement> serviceSub;


    public String getLeftServiceElements() {
        service.click();
        StringBuilder fullText = new StringBuilder();
        for (WebElement element : serviceSub) {
            fullText.append(element.getText());
        }
        return fullText.toString();
    }

    public void clickService() {
        service.click();
    }


    public class LeftSideMenu {
        @FindBy(css = ".sidebar-menu li")
        private List<WebElement> leftMenuItems;
    }

}