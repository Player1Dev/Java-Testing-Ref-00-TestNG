package _02_Suites;

import org.testng.annotations.Test;

/**
 * Created by MM on 8/16/2016.
 */
public class TestSecurity {

    @Test(groups= "security")
    public void accessHomePage() {
        System.out.println("accessHomePage()");
    }

    @Test(groups= "security")
    public void accessAdminPage() {
        System.out.println("accessAdminPage()");
    }

}