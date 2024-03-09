package com.designPattern.proxy;

public class EmployeeDaoProxy implements EmployeeDao {

    private EmployeeDao employeeDao;
    private static String allowedEmployee;

    public EmployeeDaoProxy(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    static {
        allowedEmployee = "ADMIN";
    }

    @Override
    public void createEmployee(String emp) {

        if (emp.equals("ADMIN")) {
            employeeDao.createEmployee(emp);
            return;

        }

        throw new RuntimeException(String.format("Employee type %s not allowed to make changes", emp));

    }

    @Override
    public void deleteEmployee(String emp) {

        if (emp.equals("ADMIN")) {
            employeeDao.deleteEmployee(emp);
            return;
        }

        throw new RuntimeException(String.format("Employee type %s not allowed to make changes", emp));

    }

    @Override
    public void updateEmployee(String emp) {

        if (emp.equals("ADMIN")) {
            employeeDao.updateEmployee(emp);
            return;


        }

        throw new RuntimeException(String.format("Employee type %s not allowed to make changes", emp));

    }
}
