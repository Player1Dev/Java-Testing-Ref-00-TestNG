#_04_TestngEnabled

Occasionally, we want to disable some tests because of some reasons
(like a particular api being tested in those tests is changing but
 we don’t want to stop the complete CI build which apart from this
 API should be working fine). In those situations, we can simply
 ignore/disable those tests by setting enabled attribute of @Test
 annotation to false

###Example:

     @Test(enabled = false)
        public void testSubtract() {//We are disabling this test. Look at enabled=false with @Test
            System.out.println("testSubtract()");
            Assert.assertEquals(calculator.subtract(5, 2), 3.0);
        }

###Output:

        setup()
        beforeMethod()
        testAdd()
        afterMethod()
        tearDown()
        PASSED: testAdd

        ===============================================
            Default test
            Tests run: 1, Failures: 0, Skips: 0
        ===============================================