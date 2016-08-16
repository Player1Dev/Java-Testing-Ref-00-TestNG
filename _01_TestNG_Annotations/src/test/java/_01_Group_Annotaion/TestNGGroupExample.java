package _01_Group_Annotaion;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
/**
 * Created by MM on 8/16/2016.
 */
public class TestNGGroupExample {

    @BeforeGroups("security")
    public void setUpSecurity() {
        System.out.println("TestNGGroupExampleTestNGGroupExample setUpSecurity()");
    }

    @AfterGroups("security")
    public void tearDownSecurity() {
        System.out.println("TestNGGroupExampleTestNGGroupExampletearDownSecurity()\n");
    }

    @BeforeGroups("database")
    public void setUpDatabase() {
        System.out.println("TestNGGroupExampleTestNGGroupExamplesetUpDatabase()");
    }

    @AfterGroups("database")
    public void tearDownDatabase() {
        System.out.println("TestNGGroupExampletearDownDatabase()\n");
    }

    @BeforeGroups(value="ui")
    public void setUpUI() {
        System.out.println("TestNGGroupExamplesetUpUI()");
    }

    @AfterGroups(value="ui")
    public void tearDownUI() {
        System.out.println("TestNGGroupExampletearDownUI()\n");
    }

    @Test(groups= "database")
    public void testInsert(){
        System.out.println("TestNGGroupExampletestInsert()");
    }

    @Test(groups= "database")
    public void testUpdate(){
        System.out.println("TestNGGroupExampletestUpdate()");
    }

    @Test(groups= "database")
    public void testDelete(){
        System.out.println("TestNGGroupExampletestDelete()");
    }

    @Test(groups= "security")
    public void accessHomePage() {
        System.out.println("TestNGGroupExampleaccessHomePage()");
    }

    @Test(groups= "security")
    public void accessAdminPage() {
        System.out.println("TestNGGroupExampleaccessAdminPage()");
    }

    @Test(groups= "ui")
    public void openConfirmationDialog() {
        System.out.println("TestNGGroupExampleopenConfirmationDialog()");
    }

    @Test(groups= "ui")
    public void openFileDialog() {
        System.out.println("TestNGGroupExampleopenFileDialog()");
    }
}