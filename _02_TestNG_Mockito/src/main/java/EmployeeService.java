import java.util.List;

/**
 * Created by MM on 8/17/2016.
 */
interface EmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployeeBySsn(String ssn);
}
