package hw1.TestGroupMultDiv;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMultiply {

    @Test(dataProviderClass = DataProvidersMultiply.class, dataProvider = "correct data", groups = {"test-group-multdiv"})
    public void multTest(int a, int b) {
        Calculator calculator = new Calculator();
        int actual = (int) calculator.mult(a, b);
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

}