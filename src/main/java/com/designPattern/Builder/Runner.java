package com.designPattern.Builder;

public class Runner {

    public static void main(String[] args) {
        Employee employee = Employee.EmployeeBuilder.builder().setName("Nitin").setAuntyName("Kamla").setDepartment("IT").setOrganization("MS").build();
        System.out.println(employee);
    }
}
