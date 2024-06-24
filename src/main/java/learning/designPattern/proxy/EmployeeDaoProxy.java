package learning.designPattern.proxy;

public class EmployeeDaoProxy implements EmployeeDao {

    private final EmployeeDao employeeDao;
    private static final String allowedEmployee;

    public EmployeeDaoProxy(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    static {
        allowedEmployee = "ADMIN";
    }

    @Override
    public void createEmployee(String emp) {

        if (emp.equals(allowedEmployee)) {
            employeeDao.createEmployee(emp);
            return;

        }

        throw new RuntimeException(String.format("Employee type %s not allowed to make changes", emp));

    }

    @Override
    public void deleteEmployee(String emp) {

        if (emp.equals(allowedEmployee)) {
            employeeDao.deleteEmployee(emp);
            return;
        }

        throw new RuntimeException(String.format("Employee type %s not allowed to make changes", emp));

    }

    @Override
    public void updateEmployee(String emp) {

        if (emp.equals(allowedEmployee)) {
            employeeDao.updateEmployee(emp);
            return;


        }

        throw new RuntimeException(String.format("Employee type %s not allowed to make changes", emp));

    }
}
