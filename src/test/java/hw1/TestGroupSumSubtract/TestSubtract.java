package hw1.TestGroupSumSubtract;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestSubtract {

    @Test(dataProviderClass = DataProvidersSubtract.class, dataProvider = "correct data", groups = {"test-group-sumsub"})
    public void subTest(int a, int b) {
        Calculator calculator = new Calculator();
        int actual = (int) calculator.sub(a, b);
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

}