package hw1.TestGroupSumSubtract;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestSum {

    @Test(dataProviderClass = DataProvidersSum.class, dataProvider = "correct data", groups = {"test-group-sumsub"})
    public void sumTest(int a, int b) {
        Calculator calculator = new Calculator();
        int actual = (int) calculator.sum(a, b);
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

}