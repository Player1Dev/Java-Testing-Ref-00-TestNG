#_05_TestngTimeOut

TestNG timeout feature with help of @Test(timeOut = 1000).
A @Test is supposed to complete its execution within
very short time. In case a @Test is taking unreasonably
long-time than expected, it’s something to investigate.
In those situations, we can run that @Test with applying a
timeout(in milliSeconds) like @Test(timeOut = 1000). With this way,
if the test does not complete it’s execution within applied timeout,
it will fail.

###Example:

   @Test(timeOut = 3000)//timeout in milliseconds
       public void testSubtract() throws InterruptedException {
           System.out.println("testSubtract()");
           Assert.assertEquals(calculator.subtract(5, 2), 3.0);
       }

###Output:

     setup()
     beforeMethod()
     testAdd()
     afterMethod()
     beforeMethod()
     testSubtract()
     afterMethod()
     tearDown()
     PASSED: testAdd
     FAILED: testSubtract
     org.testng.internal.thread.ThreadTimeoutException: Method org.testng.internal.TestNGMethod.testSubtract() didn't finish within the time-out 3000
         at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.doSignalAll(AbstractQueuedSynchronizer.java:1890)
         at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.signalAll(AbstractQueuedSynchronizer.java:1959)
         at java.util.concurrent.ThreadPoolExecutor.tryTerminate(ThreadPoolExecutor.java:707)
         at java.util.concurrent.ThreadPoolExecutor.processWorkerExit(ThreadPoolExecutor.java:1006)
         at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1163)
         at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
         at java.lang.Thread.run(Thread.java:745)


     ===============================================
         Default test
         Tests run: 2, Failures: 1, Skips: 0
     ===============================================