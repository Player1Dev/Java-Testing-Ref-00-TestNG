#TestNG Mockito

##Based on:

<1>  http://websystique.com/java/testing/testng-mockito-example-stubbing-void-methods/


Mockito library enables mocks creation,
verification and stubbing. In simple terms,
mock objects comes handy in situations like when you
are testing a class [A] which depends on another class [B].
 To test A in isolation, you can mock B so that while creating real
 instance of A, mock object of B will be injected into A instance.
 In this manner, you can test A in isolation without worrying about
 how B should be initialized & implemented.


 @Mock:

 Objects annotated with @Mock are not real instances,
 they are test objects created by Mockito using Class of the
 object it is applied on, instrumented to track interactions with them.
 Once created, mock object will remember all interactions with it.
 Then you can selectively verify whatever interaction you are interested in.

 ==> In our example, EmployeeServiceImpl needs EmployeeDao to perform it’s core job.
 While we are testing the real employeeService, we are mocking the employeeDao.
  This Mock object will remember all interactions/operation applied on it, which
  we will verify further down in our test.

 @InjectMocks:

 This annotation is used to mark the field on which injection
  should be performed. Mockito will create a real instance of the object
  this annotation is applied on, using either of constructor injection,
  setter injection, or property injection. Mockito will also make sure to
  inject any dependencies(@mock objects) the actual object in test might need.

 ==> In our example, a real instance of EmployeeServiceImpl will be created and
 it’s dependencies(EmployeeDao e.g.) will be injected using @mock object defined in this class.

 @Spy:

 Objects annotated with @Spy are real instances. These objects are real objects
 but with a difference that they remember all interactions/operation applied on
 them, which we can verify further down in our test.

 ==> In our example, we are using a List object employees (annotated with @Spy)
  which remembers it’s content and the operation executed on it.

 @Captor :

 @Captor is used to capture argument values which can be asserted
 further in test, after the actual verification.

 ==> In our example, we are using @Captor to fetch the employee
 object which was passed in saveEmployee method. Then
 we asseted different properties of that captured employee object.

 MockitoAnnotations.initMocks: It initializes objects
 annotated with Mockito annotations like @org.mockito.Mock,
 @InjectMocks, @Spy & @Captor. It is a mandatory call, otherwise
 the objects annotated with above mentioned annotated will not be
 initialized and so your verifications & assertions will fail.

 Stubbing : Using stubbing , we can specify a predefined behavior
 to be performed during our test.