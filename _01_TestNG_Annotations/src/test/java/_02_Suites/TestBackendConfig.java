package _02_Suites;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Created by MM on 8/16/2016.
 */
public class TestBackendConfig {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite\n");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest\n");
    }

}