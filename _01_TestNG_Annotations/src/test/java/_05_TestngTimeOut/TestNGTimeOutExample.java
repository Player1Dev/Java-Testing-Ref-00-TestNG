package _05_TestngTimeOut;

import _00_Annotation.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by MM on 8/17/2016.
 */
public class TestNGTimeOutExample {
    Calculator calculator;

    @BeforeClass
    public void setup() {
        System.out.println("TestNGTimeOutsetup()");
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("TestNGTimeOuttearDown()");
        calculator = null;
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("TestNGTimeOutbeforeMethod()");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("TestNGTimeOutafterMethod()");
    }

    @Test
    public void testAdd() {
        System.out.println("TestNGTimeOuttestAdd()");
        Assert.assertEquals(calculator.add(3, 4), 7.0);
    }

    @Test(timeOut = 1)//timeout in milliseconds
    public void testSubtract() throws InterruptedException {
        System.out.println("TestNGTimeOuttestSubtract()");
        Assert.assertEquals(calculator.subtract(5, 2), 3.0);
    }

}