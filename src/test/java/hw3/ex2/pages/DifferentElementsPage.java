package hw3.ex2.pages;

import hw2.ex1.ConfProperties;
import hw3.ex2.components.RightSideBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DifferentElementsPage {

    private WebDriver driver;

    private RightSideBar rightSideBar;

    public DifferentElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        rightSideBar = new RightSideBar(driver);
    }

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(css = "div[class='main-content-hg'] [class ='uui-button']")
    private List<WebElement> buttons;

    @FindBy(css = "[class='colors'] option")
    private List<WebElement> dropDownOptions;

    @FindBy(css = "[class='colors'] select")
    private WebElement dropDown;

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]/ul")
    private WebElement leftSection;

    @FindBy(xpath = "//*[@id=\"mCSB_2_container\"]/section[1]/div[2]/div/ul/li")
    private WebElement elementRowFirst;

    public int radiosSize() {
        return radios.size();
    }

    public int buttonsSize() {
        return buttons.size();
    }

    public int dropDownSize() {
        return dropDownOptions.size();
    }

    public boolean checkAllElements() {
        if (checkboxes.size() == Integer.parseInt(ConfProperties.getProperty("checkboxesCount")) &&
                radios.size() == Integer.parseInt(ConfProperties.getProperty("radiosCount")) &&
                buttons.size() == Integer.parseInt(ConfProperties.getProperty("buttonsCount")) &&
                dropDownOptions.size() == Integer.parseInt(ConfProperties.getProperty("dropDownCount"))) {
            return true;
        }
        return false;
    }

    public RightSideBar getRightSideBar() {
        return rightSideBar;
    }

    public boolean isDisplayedLeftSection() {
        return leftSection.isDisplayed();
    }

    public void selectCheckboxes(String name) {
        String[] checkBoxesArr = name.split(" ");
        for (WebElement element : checkboxes) {
            if (Arrays.asList(checkBoxesArr).contains(element.getText())) {
                element.click();
            }
        }
    }

    public void selectRadios(String name) {
        String[] radiosArr = name.split(" ");
        for (WebElement element : radios) {
            if (Arrays.asList(radiosArr).contains(element.getText())) {
                element.click();
            }
        }
    }

    public void selectDropdownOptions(String name) {
        String[] dropDownArr = name.split(" ");
        for (WebElement element : dropDownOptions) {
            dropDown.click();
            if (Arrays.asList(dropDownArr).contains(element.getText())) {
                element.click();
            }
        }
    }

    public boolean isIndividualLogStatusOfCheckbox(String name) {
        String[] checkBoxesArr = name.split(" ");
        boolean result = false;
        for (WebElement element : checkboxes) {
            if (Arrays.asList(checkBoxesArr).contains(element.getText())) {
                WebElement el = element.findElement(By.cssSelector("[type=checkbox]"));
                if (el.isSelected() && elementRowFirst.getText().contains("true")) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean isIndividualLogStatusOfRadios(String name) {
        String[] radiosArr = name.split(" ");
        boolean result = false;
        for (WebElement element : radios) {
            if (Arrays.asList(radiosArr).contains(element.getText())) {
                WebElement el = element.findElement(By.cssSelector("[type=radio]"));
                if (el.isSelected() && elementRowFirst.getText().contains(element.getText())) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean isIndividualLogStatusOfDropDown(String name) {
        String[] dropDownArr = name.split(" ");
        boolean result = false;
        for (WebElement element : dropDownOptions) {
            if (Arrays.asList(dropDownArr).contains(element.getText())) {
                if (elementRowFirst.getText().contains(element.getText())) {
                    result = true;
                }
            }
        }
        return result;
    }

    public void unselectCheckboxes(String name) {
        String[] checkBoxesArr = name.split(" ");
        for (WebElement element : checkboxes) {
            if (Arrays.asList(checkBoxesArr).contains(element.getText())) {
                element.click();
                element.click();
            }
        }
    }

    public boolean isIndividualLogStatusOfCheckboxUnselected(String name) {
        String[] checkBoxesArr = name.split(" ");
        boolean result = false;
        for (WebElement element : checkboxes) {
            if (Arrays.asList(checkBoxesArr).contains(element.getText())) {
                element.click();
                element.click();
                WebElement el = element.findElement(By.cssSelector("[type=checkbox]"));
                if (!el.isSelected() && elementRowFirst.getText().contains("false")) {
                    result = true;
                }
            }
        }
        return result;
    }

}