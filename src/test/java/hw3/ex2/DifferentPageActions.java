package hw3.ex2;

import hw3.ex2.pages.DifferentElementsPage;
import hw3.ex2.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DifferentPageActions {

    WebDriver driver;

    public static HomePage homePage;
    public static DifferentElementsPage differentElementsPage;

    //8. Check interface on Different elements page, it contains all needed elements
    @Test
    public void differentPageEl() {

        differentElementsPage.checkAllElements();

    }

    //9. Assert that there is Right Section
    @Test
    public void differentPageRightSection() {

        Assert.assertTrue(differentElementsPage.getRightSideBar().isDisplayedRightSection());

    }

    //10. Assert that there is Left Section
    @Test
    public void leftSection() {

        Assert.assertTrue(differentElementsPage.isDisplayedLeftSection());

    }

    //11. Select checkboxes
    @Test
    public void selectCheckBoxes() {

        differentElementsPage.selectCheckboxes(ConfProperties.getProperty("selectCheckboxes"));

    }

    //12.Assert that for each checkbox there is an individual log row
    //and value is corresponded to the status of checkbox
    @Test
    public void individualLogStatusOfCheckbox() {

        differentElementsPage.selectCheckboxes(ConfProperties.getProperty("selectCheckboxes"));
        Assert.assertTrue(differentElementsPage.isIndividualLogStatusOfCheckbox(ConfProperties.getProperty("selectCheckboxes")));

    }

    //13. Select radio
    @Test
    public void selectRadio() {

        differentElementsPage.selectRadios(ConfProperties.getProperty("selectRadios"));

    }

    //14. Assert that for radiobutton there is a log row
    // and value is corresponded to the status of radiobutton
    @Test
    public void radiobutton() {

        differentElementsPage.selectRadios(ConfProperties.getProperty("selectRadios"));
        Assert.assertTrue(differentElementsPage.isIndividualLogStatusOfRadios(ConfProperties.getProperty("selectRadios")));

    }

    //15. Select in dropdown
    @Test
    public void selectDropdown() {

        differentElementsPage.selectDropdownOptions(ConfProperties.getProperty("selectDropDown"));

    }


    //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
    @Test
    public void dropdownLogRow() {

        differentElementsPage.selectDropdownOptions(ConfProperties.getProperty("selectDropDown"));
        Assert.assertTrue(differentElementsPage.isIndividualLogStatusOfDropDown(ConfProperties.getProperty("selectDropDown")));

    }

    //17. Unselect and assert checkboxes
    @Test
    public void unselectCheckboxes() {

        differentElementsPage.unselectCheckboxes(ConfProperties.getProperty("selectCheckboxes"));

    }

    //18. Assert that for each checkbox there is an individual log row
    // and value is corresponded to the status of checkbox.
    @Test
    public void eachCheckboxIndividualLog() {

        Assert.assertTrue(differentElementsPage.isIndividualLogStatusOfCheckboxUnselected(ConfProperties.getProperty("selectCheckboxes")));

    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        homePage.open();
        homePage.login(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));
        homePage.getHeaderMenu().openDifferentElementsPage();

        differentElementsPage = new DifferentElementsPage(driver);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
