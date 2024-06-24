package learning.designPattern.proxy;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void createEmployee(String empe) {
        System.out.println("Employee Object created");
    }

    @Override
    public void deleteEmployee(String emp) {
        System.out.println("Employee Object Deleted");
    }

    @Override
    public void updateEmployee(String emp) {
        System.out.println("Employee Object updated");
    }
}
