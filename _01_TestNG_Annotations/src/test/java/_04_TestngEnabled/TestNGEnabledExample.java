package _04_TestngEnabled;

import _00_Annotation.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by MM on 8/17/2016.
 */
public class TestNGEnabledExample {

    Calculator calculator;

    @BeforeClass
    public void setup() {
        System.out.println("TestNGEnabledsetup()");
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("TestNGEnabledtearDown()");
        calculator = null;
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("TestNGEnabledbeforeMethod()");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("TestNGEnabledafterMethod()");
    }

    @Test
    public void testAdd() {
        System.out.println("TestNGEnabledtestAdd()");
        Assert.assertEquals(calculator.add(3, 4), 7.0);
    }

    @Test(enabled = false)
    public void testSubtract() {//We are disabling this test. Look at enabled=false with @Test
        System.out.println("TestNGEnabledtestSubtract()");
        Assert.assertEquals(calculator.subtract(5, 2), 3.0);
    }

}