#_06_ExpectedExceptions

TestNG timeout feature with help of @Test(timeOut = 1000).
A @Test is supposed to complete its execution within
very short time. In case a @Test is taking unreasonably
long-time than expected, it’s something to investigate.
In those situations, we can run that @Test with applying a
timeout(in milliSeconds) like @Test(timeOut = 1000). With this way,
if the test does not complete it’s execution within applied timeout,
it will fail.

###Example:

  @Test(expectedExceptions = ArithmeticException.class)
      public void testDivideByZero() {
          System.out.println("testDivideByZero()");
          Assert.assertEquals(calculator.divide(16, 0), 12345);
      }

   __Test testDivideByZero passed successfully despite throwing exception because we informed TestNG
   that this particular exception is expected behavior.__

###Output:

     setup()
     testAdd()
     testDivide()
     testDivideByZero()
     tearDown()
     PASSED: testAdd
     PASSED: testDivide
     PASSED: testDivideByZero

     ===============================================
         Default test
         Tests run: 3, Failures: 0, Skips: 0
     ===============================================

     Test testDivideByZero passed successfully despite throwing exception because we informed TestNG
     that this particular exception is expected behavior.