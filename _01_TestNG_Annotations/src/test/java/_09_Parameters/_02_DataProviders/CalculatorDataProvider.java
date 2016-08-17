package _09_Parameters._02_DataProviders;

import org.testng.annotations.DataProvider;

/**
 * Created by MM on 8/17/2016.
 */
public class CalculatorDataProvider {

    @DataProvider(name = "addMethodDataProvider")
    public static Object[][] addMethodDataProvider() {
        return new Object[][] { { 2, 5, 7 }, { 3, 7, 10 }, { 4, 5, 9 } };
    }

    @DataProvider(name = "subtractMethodDataProvider")
    public static Object[][] subtractMethodDataProvider() {
        return new Object[][] { { 2, 5, -3 }, { 3, 7, -4 }, { 24, 5, 19 } };
    }

    @DataProvider(name = "multiplyMethodDataProvider")
    public static Object[][] multiplyMethodDataProvider() {
        return new Object[][] { { 2, 5, 10 }, { 3, 7, 21 }, { 4, 5, 20 } };
    }

}
