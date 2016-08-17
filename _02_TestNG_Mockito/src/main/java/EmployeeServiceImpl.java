import java.util.List;

/**
 * Created by MM on 8/17/2016.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao dao;

    public EmployeeServiceImpl(EmployeeDao dao) {
        this.dao = dao;
    }

    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }

    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }

    public void deleteEmployeeBySsn(String ssn) {
        dao.deleteEmployeeBySsn(ssn);
    }
}