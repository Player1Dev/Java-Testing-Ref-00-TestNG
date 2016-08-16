package _02_Suites;

import org.testng.annotations.Test;

/**
 * Created by MM on 8/16/2016.
 */
public class TestDataBase {

    @Test(groups= "database")
    public void testInsert(){
        System.out.println("testInsert()");
    }

    @Test(groups= "database")
    public void testUpdate(){
        System.out.println("testUpdate()");
    }

    @Test(groups= "database")
    public void testDelete(){
        System.out.println("testDelete()");
    }

}