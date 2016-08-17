package _08_DependsOnGroups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * Created by MM on 8/17/2016.
 */
public class TesNGDependsOnGroupsExample {

    @BeforeGroups("security")
    public void setUpSecurity() {
        System.out.println("setUpSecurity()");
    }

    @AfterGroups("security")
    public void tearDownSecurity() {
        System.out.println("tearDownSecurity()\n");
    }

    @BeforeGroups("database")
    public void setUpDatabase() {
        System.out.println("setUpDatabase()");
    }

    @AfterGroups("database")
    public void tearDownDatabase() {
        System.out.println("tearDownDatabase()\n");
    }

    @BeforeGroups(value="ui")
    public void setUpUI() {
        System.out.println("setUpUI()");
    }

    @AfterGroups(value="ui")
    public void tearDownUI() {
        System.out.println("tearDownUI()\n");
    }

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

    @Test(groups= "security")
    public void accessHomePage() {
        System.out.println("accessHomePage()");
    }

    @Test(groups= "security")
    public void accessAdminPage() {
        System.out.println("accessAdminPage()");
        throw new RuntimeException();
    }

    @Test(groups= "ui")
    public void openConfirmationDialog() {
        System.out.println("openConfirmationDialog()");
    }

    @Test(groups= "ui")
    public void openFileDialog() {
        System.out.println("openFileDialog()");
    }

    @Test(dependsOnGroups= {"ui"})
    public void uiGroupDependentTest(){
        System.out.println("uiGroupDependentTest()");
    }


    @Test(dependsOnGroups= {"security","database"})
    public void backendGroupDependentTest1(){
        System.out.println("backendGroupDependentTest1()");
    }

    @Test(dependsOnGroups= {"security","database"}, alwaysRun=true)
    public void backendGroupDependentTest2(){
        System.out.println("backendGroupDependentTest2()");
    }

}