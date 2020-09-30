package hw1.TestGroupMultDiv;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDivide {

    @Test(dataProviderClass = DataProvidersDivide.class, dataProvider = "correct data", groups = {"test-group-multdiv"})
    public void divTest(int a, int b) {
        Calculator calculator = new Calculator();
        int actual = (int) calculator.div(a, b);
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

}