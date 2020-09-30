package hw3.ex2.components;

//import hw3.ex2.pages.DifferentElementsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenu {

    private WebDriver driver;

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/header/div/nav/ul[1]/li[3]/a")
    private WebElement service;

    @FindBy(xpath = "/html/body/header/div/nav/ul[1]/li[3]/ul")
    private List<WebElement> serviceSub;

    @FindBy(xpath = "/html/body/header/div/nav/ul[1]/li[3]/ul/li[8]/a")
    private WebElement differentElementsPage;

    public String getExistsServiceElements() {
        service.click();
        StringBuilder fullText = new StringBuilder();
        for (WebElement element : serviceSub) {
            fullText.append(element.getText());
        }
        return fullText.toString();
    }

    public void openDifferentElementsPage() {
        service.click();
        differentElementsPage.click();
    }
}