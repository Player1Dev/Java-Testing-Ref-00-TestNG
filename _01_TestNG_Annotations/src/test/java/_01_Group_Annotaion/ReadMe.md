#Group Exclusion:

Let’s assume that we only want to run security and database related tests
and not the ones related to ui. We can exclude the ‘ui’ group from
execution using testNG configuration xml file.

Create an XML file testng.xml (or with any other name) with below
content in src/test/resources(if you are using maven) or in
any other place in your project.

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
            <class name="com.websystique.testng.TestNGGroupExample" />
        </classes>
    </test>

</suite>

Now , if you are using maven based project, you can configure maven-surefire-plugin in pom.xml.
 Following is the pom.xml for this project:

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.websystique.testng</groupId>
    <artifactId>TestNGAnnotationsExample</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>

    <name>TestNGAnnotationsExample</name>

    <dependencies>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.9.4</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.18.1</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>src/test/resources/_01_testng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

##Run:
    mvn clean test                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     TestNG Groups Example
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                Post containing full example code for testNG grouping related aspects.
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                2) Suite Annotations:

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                Every Test you run using TestNG runs as part of a suite. A Suite in testNG is represented by one XML file, usually named as testng.xml. <suite> tag is the first tag in XML file which represents a suite and it may contains one or more <test> tags. Each <test> tag in turn may contain one or more <classes>, <packages>, <groups> tags and more.

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                You can provide a Suite level configuration/setup and/or a Test [<test> tag] level configuration setup using following annotations:
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                @BeforeSuite, @AfterSuite

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                Method annotated with @BeforeSuite is executed only once, before any of the tests method execution in a given suite. It is an ideal place to do some setup/initialization for environments which will be shared among all tests of this suite. Method annotated with @AfterSuite gets executed only once for a suite only after all of the tests of that suite finished execution.
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                @BeforeTest, @AfterTest

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                Method annotated with @BeforeTest is executed only once, before any of the tests method execution in a given <test> tags which may contain multiple classes and packages. It is an ideal place to do some setup/initialization for environments which will be shared among all tests defined in this <test> tag. Method annotated with @AfterTest gets executed only once for a given <test> tag, and only after all of the tests of that <test> tag finished execution.