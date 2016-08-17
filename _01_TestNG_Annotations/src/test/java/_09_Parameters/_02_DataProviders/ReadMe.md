#_09_Parameters_DataProvider

##  Note:

@DataProvider annotation to parameterize your tests in order to write data-driven tests.
In data-driven testing, we run the same tests multiple times but with different sets of
data which we pass into test methods using parameters.

##Example:

    public class CalculatorDataProvider {

        @DataProvider(name = "addMethodDataProvider")
        public static Object[][] addMethodDataProvider() {
            return new Object[][] { { 2, 5, 7 }, { 3, 7, 10 }, { 4, 5, 9 } };
        }

        @DataProvider(name = "subtractMethodDataProvider")
        public static Object[][] subtractMethodDataProvider() {
            return new Object[][] { { 2, 5, -3 }, { 3, 7, -4 }, { 24, 5, 19 } };
        }

        @DataProvider(name = "multiplyMethodDataProvider")
        public static Object[][] multiplyMethodDataProvider() {
            return new Object[][] { { 2, 5, 10 }, { 3, 7, 21 }, { 4, 5, 20 } };
        }

    }


    public class TestNGMultipleDataProviderExample {

        @Test(dataProvider = "addMethodDataProvider", dataProviderClass = CalculatorDataProvider.class)
        public void testAddMethod(int a, int b, int expectedResult) {
            Calculator calculator = new Calculator();
            Assert.assertEquals(calculator.add(a, b), expectedResult);
        }

        @Test(dataProvider = "subtractMethodDataProvider", dataProviderClass = CalculatorDataProvider.class)
        public void testSubtractMethod(int a, int b, int expectedResult) {
            Calculator calculator = new Calculator();
            Assert.assertEquals(calculator.subtract(a, b), expectedResult);
        }

        @Test(dataProvider = "multiplyMethodDataProvider", dataProviderClass = CalculatorDataProvider.class)
        public void testMultiplyMethod(int a, int b, int expectedResult) {
            Calculator calculator = new Calculator();
            Assert.assertEquals(calculator.multiply(a, b), expectedResult);
        }

    }


##Output:

      PASSED: testAddMethod(2, 5, 7)
      PASSED: testAddMethod(3, 7, 10)
      PASSED: testAddMethod(4, 5, 9)
      PASSED: testMultiplyMethod(2, 5, 10)
      PASSED: testMultiplyMethod(3, 7, 21)
      PASSED: testMultiplyMethod(4, 5, 20)
      PASSED: testSubtractMethod(2, 5, -3)
      PASSED: testSubtractMethod(3, 7, -4)
      PASSED: testSubtractMethod(24, 5, 19)

      ===============================================
          Default test
          Tests run: 9, Failures: 0, Skips: 0
      ===============================================