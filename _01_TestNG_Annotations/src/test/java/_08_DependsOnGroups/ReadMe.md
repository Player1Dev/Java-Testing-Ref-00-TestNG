#_08_DependsOnGroups

TestNG groups dependency example showing a test depending on
groups of tests methods using @Test annotation’s dependsOnGroups
and alwaysRun attributes.

dependsOnGroups : dependsOnGroups attribute on a test method
[test1 e.g.] specifies all the groups [group1, group2,..]
this test method depends on. It means test1 will start
execution only after all the tests in all the groups it
depends on executed successfully. If any of the tests in
groups specified via dependsOnGroups attribute failed,
then test1 will be skipped.

alwaysRun=true : Setting alwaysRun attribute on a test method
to true forces the execution of this test even if the some tests
in the group it depends on were failed.

###Example:

       Test(dependsOnGroups= {"security","database"})
       public void backendGroupDependentTest1(){
           System.out.println("backendGroupDependentTest1()");
       }

       @Test(dependsOnGroups= {"security","database"}, alwaysRun=true)
       public void backendGroupDependentTest2(){
           System.out.println("backendGroupDependentTest2()");
       }


###Output:

    setUpSecurity()
    accessAdminPage()
    accessHomePage()
    tearDownSecurity()

    setUpUI()
    openConfirmationDialog()
    openFileDialog()
    tearDownUI()

    setUpDatabase()
    testDelete()
    testInsert()
    testUpdate()
    tearDownDatabase()

    backendGroupDependentTest2()

    uiGroupDependentTest()

    PASSED: accessHomePage
    PASSED: openConfirmationDialog
    PASSED: openFileDialog
    PASSED: testDelete
    PASSED: testInsert
    PASSED: testUpdate
    PASSED: backendGroupDependentTest2
    PASSED: uiGroupDependentTest
    FAILED: accessAdminPage
    java.lang.RuntimeException
        at com.websystique.testng.TesNGDependsOnGroupsExample.accessAdminPage(TesNGDependsOnGroupsExample.java:62)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:606)
        at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:84)
        at org.testng.internal.Invoker.invokeMethod(Invoker.java:714)
        at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:901)
        at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1231)
        at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)
        at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)
        at org.testng.TestRunner.privateRun(TestRunner.java:767)
        at org.testng.TestRunner.run(TestRunner.java:617)
        at org.testng.SuiteRunner.runTest(SuiteRunner.java:334)
        at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)
        at org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)
        at org.testng.SuiteRunner.run(SuiteRunner.java:240)
        at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
        at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)
        at org.testng.TestNG.runSuitesSequentially(TestNG.java:1224)
        at org.testng.TestNG.runSuitesLocally(TestNG.java:1149)
        at org.testng.TestNG.run(TestNG.java:1057)
        at org.testng.remote.RemoteTestNG.run(RemoteTestNG.java:111)
        at org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:204)
        at org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:175)

    SKIPPED: backendGroupDependentTest1

    ===============================================
        Default test
        Tests run: 10, Failures: 1, Skips: 1
    ===============================================


    ===============================================
    Default suite
    Total tests run: 10, Failures: 1, Skips: 1
    ===============================================