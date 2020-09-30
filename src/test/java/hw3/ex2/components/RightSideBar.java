package hw3.ex2.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RightSideBar {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div/div[3]")
    private WebElement rightSection;


    public RightSideBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayedRightSection() {
        return rightSection.isDisplayed();
    }

}
