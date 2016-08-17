#_09_Parameters_DataProvider

##  Note:

@DataProvider annotation to parameterize your tests in order to write data-driven tests.
In data-driven testing, we run the same tests multiple times but with different sets of
data which we pass into test methods using parameters.

##Example:

    @DataProvider(name = "addMethodDataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{{2, 5, 7}, {3, 7, 10}, {4, 5, 9}};
    }

    @Test(dataProvider = "addMethodDataProvider")
    public void testAddMethod(int a, int b, int result) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(a, b), result);
    }


##Output:

   PASSED: testAddMethod(2, 5, 7)
   PASSED: testAddMethod(3, 7, 10)
   PASSED: testAddMethod(4, 5, 9)

   ===============================================
       Default test
       Tests run: 3, Failures: 0, Skips: 0
   ===============================================