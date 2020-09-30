package hw1.TestGroupMultDiv;

import org.testng.annotations.DataProvider;

public class DataProvidersDivide {


    @DataProvider(name = "correct data")
    public static Object[][] correctData() {
        return new Object[][] {{4, 2},{4,2}};
    }
}