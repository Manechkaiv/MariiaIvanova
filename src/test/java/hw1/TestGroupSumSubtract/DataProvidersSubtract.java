package hw1.TestGroupSumSubtract;

import org.testng.annotations.DataProvider;

public class DataProvidersSubtract {


    @DataProvider(name = "correct data")
    public static Object[][] correctData() {
        return new Object[][] {{4, 2},{4,2}};
    }
}