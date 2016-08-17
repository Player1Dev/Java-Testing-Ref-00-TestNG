#_07_DependsOnMethods

TestNG dependency example between different test methods
using @Test annotation’s dependsOnMethods and alwaysRun attributes.

A very simple and real life use case [where these attributes
can be handy] is user update operations e.g. In order to update a
user, it must be created at first place. So while writing tests,
you can write both createUser and updateUser tests, make updateUser
depends on createUser, and execute updateUser if and only if the
createUser executed successfully.

dependsOnMethods : dependsOnMethods attribute on a test method
[test1 e.g.] specifies all the test methods [test2, test3,..]
this test method depends on. It means test1 will start execution
only after all the tests it depends on executed successfully.
If any of the tests specified via dependsOnMethods attribute failed,
then test1 will be skipped.

alwaysRun=true : Setting alwaysRun attribute on a test method
to true forces the execution of this test even if the tests it
depends on were failed.

###Example:

    @Test(dependsOnMethods={"testAdd", "testDivide"})
    public void testProcessRealNumbers() {
        System.out.println("testProcessRealNumbers()");
    }

  @Test(dependsOnMethods={"testAdd", "testDivide"}, alwaysRun=true)
      public void testProcessEvenNumbers() {
          System.out.println("testProcessEvenNumbers()");
      }

    alwaysRun=true : Setting alwaysRun attribute on a test method
    to true forces the execution of this test even if the tests it
    depends on were failed.


###Output:

     beforeMethod()
     testAdd()
     afterMethod()

     beforeMethod()
     testDivide()
     afterMethod()

     beforeMethod()
     testProcessEvenNumbers()
     afterMethod()

     PASSED: testAdd
     PASSED: testProcessEvenNumbers
     FAILED: testDivide
     java.lang.ArithmeticException: / by zero
         at com.websystique.testng.Calculator.divide(Calculator.java:10)
         at com.websystique.testng.TestNGDependsOnMethodsExample.testDivide(TestNGDependsOnMethodsExample.java:31)
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

     SKIPPED: testProcessRealNumbers

     ===============================================
         Default test
         Tests run: 4, Failures: 1, Skips: 1
     ===============================================