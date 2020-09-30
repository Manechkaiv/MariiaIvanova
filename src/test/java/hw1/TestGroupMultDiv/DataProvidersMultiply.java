package hw1.TestGroupMultDiv;


import org.testng.annotations.DataProvider;

public class DataProvidersMultiply {

    @DataProvider(name = "correct data")
    public static Object[][] correctData() {
        return new Object[][]{{2, 2}, {2, 2}};
    }
}