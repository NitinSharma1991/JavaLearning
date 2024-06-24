package learning.designPattern.proxy;

public class Runner {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        EmployeeDao employeeDaoProxy = new EmployeeDaoProxy(employeeDao);
        employeeDaoProxy.createEmployee("ADMIN");
        employeeDaoProxy.deleteEmployee("ADMIN");
        employeeDaoProxy.updateEmployee("ADMIN");
        employeeDaoProxy.createEmployee("CLIENT");
    }
}
