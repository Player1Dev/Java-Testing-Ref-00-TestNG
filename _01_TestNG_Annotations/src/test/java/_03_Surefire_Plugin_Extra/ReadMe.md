#_03_Surefire_Plugin_Extra

1) Execute all tests :

        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
        <suite name="tests">

            <test name="full">
                <packages>
                    <package name="com.websystique.*" />
                </packages>
            </test>

        </suite>

2) Execute all tests but not the ones within group ui :

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

3) Execute all tests but not the ones within group ui [using classes instead of packages]:

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

        </suite>

4) Execute the tests separated in different categories(front-end, back-end);

        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
        <suite name="tests">

            <test name="front-end">
                <packages>
                    <package name="com.websystique.testng.frontend.*" />
                </packages>
            </test>

            <test name="back-end">
                <packages>
                    <package name="com.websystique.testng.backend.*" />
                </packages>
            </test>

        </suite>

5) Execute the tests separated in different categories(front-end, back-end); Run both front-end and back-end in parallel. Note that tests within one category(front-end e.g.) will still be executed in single thread.

        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
        <suite name="tests" parallel="tests" thread-count="2">

            <test name="front-end">
                <packages>
                    <package name="com.websystique.testng.frontend.*" />
                </packages>
            </test>

            <test name="back-end">
                <packages>
                    <package name="com.websystique.testng.backend.*" />
                </packages>
            </test>

        </suite>

###Maven Surefire Plugin & TestNG

For maven based project, the popular approach to run the tests is
using maven-surefire-plugin which is used by-default whenever
test goal is executed [ with 'mvn test' / 'mvn install' e.g.].
You can configure this plugin in pom.xml to provide some configuration
information like the location of test artifacts [testng.xml] and other properties.

        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.18.1</version>
            <configuration>
                <suiteXmlFiles>
                    <suiteXmlFile>src/test/resources/testng.xml</suiteXmlFile>
                </suiteXmlFiles>
             </configuration>
        </plugin>