#_00_TestNG_Hello_World

##Based on:
http://websystique.com/java/testing/testng-hello-world-example/

##Important points:

Source files are created under src/main/java and test files
are created under src/test/java. It’s best practice to create
the test files in a package created with same name as the package
containing actual source files. Mimicing the same package name in
test as in source keep things clean and understandable.

Name of test class must have ‘Test’ as prefix or suffix if you plan
to execute the tests via maven (mvn test). This does not hold if
you are running the test via eclipse plugin. Also, the Test class
name should ideally reflect the source class name you are testing.

Name of test method can be anything. Ideally, name should reflect
which method of source file you are testing. Including ‘test’ is not
required in testcase name.

##Note:

@Test annotation is what makes a method a test method.
With TestNG, unit-testing a method involves calling
that actual method in a test method annotated with
@Test, asserting the output from actual method for
success/failure. That’s what we did above.
We called the getVatOnAmount on a real instance and then
used TestNG Assert api to assert the return value from
actual method. If any of the assertion fails, complete
@Test will fail. Assert API provides dozens of method
for comparing the expected result with the actual result.