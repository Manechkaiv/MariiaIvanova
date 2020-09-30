package hw1.TestGroupSumSubtract;


import org.testng.annotations.DataProvider;

public class DataProvidersSum {


    @DataProvider(name = "correct data")
    public static Object[][] correctData() {
        return new Object[][] {{2, 2},{2,2}};
    }
}