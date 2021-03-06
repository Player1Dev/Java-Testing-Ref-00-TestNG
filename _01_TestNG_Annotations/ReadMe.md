#_01_TestNG_Annotation

##Based on:
<1>http://websystique.com/java/testing/testng-annotations-example/

<2>http://websystique.com/java/testing/testng-groups-example/

<3>http://websystique.com/java/testing/testng-suites-example/

<4>http://websystique.com/java/testing/maven-surefire-plugin-testng/


##Run Command:

    mvn clean test

##Important points:

@BeforeClass, @AfterClass

Method annotated with @BeforeClass will be executed only once,
before the first test method in this class starts to run. It’s a good place to
do any initialization or configuration setup which is common to all test methods
and eventually may be used in those test methods. Note how we created an instance
of calculator in @BeforeClass method which is used throughout all tests method.
Method annotated with @AfterClass will be executed only once but only after all
tests case have been executed. It provides a handle to do some cleanup after all
tests in this class have been executed. You can see in above output that

@BeforeClass and @AfterClass were executed only once and that too at very beginning and at very end.

@BeforeMethod, @AfterMethod

Method annotated with @BeforeMethod will be executed before each test method.
Similarly @AfterMethod method will be executed after each test method execution.
 @BeforeMethod annotated method is a good place to initialize some setup which
 can be used and eventually altered by the test method. Similarly @AfterMethod
 annotated method is a handy place to cleanup the setup created in @BeforeMethod
 and updated by @Test method itself.

Optionally, you can provide some specific arguments in @BeforeMethod and @AfterMethod
 methods in order to get some info related to the test in execution. In our example,
 we have declared an argument Method which eventually helps us to find the name of the test in execution.
@Test

Methods annotated with @Test are actual test methods, serving as unit test in above
example. In @Test methods, we call real methods and assert the output/behavior from
actual method for success/failure.


##Advanced Annotations


##1) Group Annotations:

TestNG allows us to group several tests together. You can group certain tests
based on what behavior/aspect they are actually testing. You may have a scenario
where few tests belong to a certain group(say database) and other ones belong to
other group(say security) and yet another one belong to other group(say UI).
With this approach you may decide to execute only certain group of test and skip
other ones(let’s say there was a regression on database related code, so only execute
database related tests). Several Tests can belong to a group and a test can be part of several groups.
@BeforeGroups, @AfterGroups

Method annotated with @BeforeGroups gets executed only once for a group before
any of the test of that group executes. Method annotated with @AfterGroups gets
executed only once for a group only after all of the tests of that group finished execution.

TestNG Groups Example
Post containing full example code for testNG grouping related aspects.

###Group Exclusion:

Let’s assume that we only want to run security and database related tests
and not the ones related to ui. We can exclude the ‘ui’ group from
execution using testNG configuration xml file.

Create an XML file testng.xml (or with any other name)

Now , if you are using maven based project, you can configure maven-surefire-plugin in pom.xml.

    Run:
    mvn clean test

##2) Suite Annotations:


Every Test you run using TestNG runs as part of a suite. A Suite in testNG is
represented by one XML file, usually named as testng.xml. <suite> tag is the
first tag in XML file which represents a suite and it may contains one or more
<test> tags. Each <test> tag in turn may contain one or more <classes>, <packages>,
 <groups> tags and more.
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               Method annotated with @BeforeTest is executed only once, before any of the tests method execution in a given <test> tags which may contain multiple classes and packages. It is an ideal place to do some setup/initialization for environments which will be shared among all tests defined in this <test> tag. Method annotated with @AfterTest gets executed only once for a given <test> tag, and only after all of the tests of that <test> tag finished execution.