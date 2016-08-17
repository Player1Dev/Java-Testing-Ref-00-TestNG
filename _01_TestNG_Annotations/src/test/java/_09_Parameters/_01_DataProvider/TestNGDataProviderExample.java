package _09_Parameters._01_DataProvider;

import _00_Annotation.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by MM on 8/17/2016.
 */
public class TestNGDataProviderExample {

    @DataProvider(name = "addMethodDataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{{2, 5, 7}, {3, 7, 10}, {4, 5, 9}};
    }

    @Test(dataProvider = "addMethodDataProvider")
    public void testAddMethod(int a, int b, int result) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(a, b), result);
    }

}