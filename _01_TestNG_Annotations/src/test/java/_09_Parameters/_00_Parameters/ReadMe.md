#_09_Parameters

##  Run Command:

    mvn clean test

##OR:

    For Intellj

    <1>Right Click TestNGParametersExample.java
    <2>Click Create 'TestNGParametersExample' (see TestNG icon)
    <3>Config it With Suite and give proper path to suite file

##  Note:

Parameterize your TestNG tests using TestNG @Parameters
annotation which is used to pass simple primitive parameters
from configuration file to test methods. These parameters
are defined in suite [testng.xml] file.
In TestNG, there are primarily two popular ways to pass parameters
to your tests in order to do data-driven testing:

1) Using @Parameters annotation on test methods + declaring
parameters in testng.xml.
This approach is useful if parameters to be passed are
simple primitive types like int, String,..etc.

2) Using @DataProvider
When you want to pass complex parameters, then @DataProvider is the way to go.

##Example:

###<1>  TestNGParametersExample.java

       @Parameters({ "number1", "number2", "sum" })
          @Test
          public void testAdd(int number1, int number2, int sum) {
              Calculator calculator = new Calculator();
              Assert.assertEquals(calculator.add(number1, number2), sum);
          }

          @Parameters({ "number1", "number2", "difference" })
          @Test
          public void testSubtract(int number1, int number2, int difference) {
              Calculator calculator = new Calculator();
              Assert.assertEquals(calculator.subtract(number1, number2), difference);
          }

          @Parameters({ "number1", "number2", "multiplication", "global_count" })
          @Test
          public void testMultiply(int number1, int number2, int multiplication, int global_count) {
              Calculator calculator = new Calculator();
              for (int i = 0; i < global_count; i++) {
                  Assert.assertEquals(calculator.multiply(number1, number2), multiplication);
              }
          }

          @Parameters({ "number1", "number2", "division" })
          @Test
          public void testDivide(int number1, int number2, int division) {
              Calculator calculator = new Calculator();
              Assert.assertEquals(calculator.divide(number1, number2), division);
          }

          @Parameters({ "number1", "number2", "squaresum" })
          @Test
          public void testSquareSum(int number1, int number2, @Optional("925") int squaresum) {
              Calculator calculator = new Calculator();
              Assert.assertEquals(calculator.squaresum(number1, number2), squaresum);
          }

###<2>  _09_testngParameters.xml

        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
        <suite name="simple_suite">

            <parameter name="global_count" value="10" />

            <test name="calc">
                <parameter name="number1"  value="30" />
                <parameter name="number2"  value="5" />
                <parameter name="sum"  value="35" />
                <parameter name="difference"  value="25" />
                <parameter name="multiplication"  value="150" />
                <parameter name="division"  value="6" />
                <classes>
                    <class name="com.websystique.testng.TestNGParametersExample"/>
                </classes>
            </test>

        </suite>


Look at above testng.xml. Content of above file is usual testng.xml
content but with some additional information.
We are passing parameters this time using <parameter/> tags.
Here we have declared one suite-level parameter named global_count
 and six test level parameters. All these 7 parameters will now be
 available in out test methods when using @Parameters annotation.

It’s worth to remember that this way of parameter passing is limited
 to primitive data types. For complex objects, we need to look at
 DataProvider.

If you review the Test class, each method is annotated with @Parameters.
The values mentioned in @Parameters annotations are directly mapped to the
 parameters in test methods and are passed by testng.xml. testAdd,
 testSubtract, testMultiply & testDevide each works on parameters which
 are declared in testng.xml. But with testSquaresum method, you can see
 that we are using a parameter squaresum which is not declared in testng.xml.
 It is optional and is represented by @Optional annotation. We use Optional
 when the value is not necessarily specified as parameter in testNG.xml.
 In case testng.xml contains a parameter with the same name, the value declared
 in testng.xml will be used in test method parameter. But in case a parameter is
  not declared, it’s Optional value mentioned in method parameter will be taken into account.


###<3>  pom.xml

        ........................
        ...........................

         <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <version>2.18.1</version>
                        <configuration>
                            <suiteXmlFiles>
                                <suiteXmlFile>src/test/resources/_09_testngParameters.xml</suiteXmlFile>
                            </suiteXmlFiles>
                        </configuration>
                    </plugin>
                </plugins>
            </build>

            ........................
            ...........................


##Output:

   [TestNG] Running:
     D:\Sorcecode\java\Java\Java_Testing_Ref_00_TestNG\_01_TestNG_Annotations\target\test-classes\_09_testngParameters.xml

   ===============================================
   simple_suite
   Total tests run: 5, Failures: 0, Skips: 0
   ===============================================