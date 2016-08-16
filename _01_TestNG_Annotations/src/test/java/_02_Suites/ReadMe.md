#TestNG Suites Example:

A Suite in TestNG is represented by one XML file,
usually named as testng.xml. <suite> tag is the
first tag in XML file which represents a suite and it
may contains one or more <test> tags. Each <test> tag in
turn may contain one or more <classes>, <packages>, <groups>
 tags and more.

When TestNG runs a suite, it basically reads the content of
this file and executes the tests based on conditions defined in this XML file.

Let’s take following _02_testngSuites for example:                                                                                                                                                                                                                                                                                                                                                                                                               Method annotated with @BeforeClass will be executed only once, before the first test method in this class starts to run. It’s a good place to do any initialization or configuration setup which is common to all test methods and eventually may be used in those test methods. Note how we created an instance of calculator in @BeforeClass method which is used throughout all tests method. Method annotated with @AfterClass will be executed only once but only after all tests case have been executed. It provides a handle to do some cleanup after all tests in this class have been executed. You can see in above output that @BeforeClass and @AfterClass were executed only once and that too at very beginning and at very end.
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        @BeforeMethod, @AfterMethod
##More Suite Examples

###(1) Execute all tests :

        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
        <suite name="tests">

            <test name="full">
                <packages>
                    <package name="com.websystique.*" />
                </packages>
            </test>

        </suite>

###(2) Execute all tests but not the ones within group ui :

        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
        <suite name="tests">

            <test name="backend">
                <groups>
                    <run>
                        <exclude name="ui" />
                    </run>
                </groups>
                <packages>
                    <package name="com.websystique.*" />
                </packages>
            </test>

        </suite>

###(3) Execute all tests but not the ones within group ui [using classes instead of packages]:

        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
        <suite name="tests">

            <test name="backend">
                <groups>
                    <run>
                        <exclude name="ui" />
                    </run>
                </groups>
                <classes>
                    <class name="com.websystique.testng.TestCalculator" />
                </classes>
            </test>

        </suite>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           Method annotated with @BeforeTest is executed only once, before any of the tests method execution in a given <test> tags which may contain multiple classes and packages. It is an ideal place to do some setup/initialization for environments which will be shared among all tests defined in this <test> tag. Method annotated with @AfterTest gets executed only once for a given <test> tag, and only after all of the tests of that <test> tag finished execution.