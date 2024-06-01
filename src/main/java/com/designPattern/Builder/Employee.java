package com.designPattern.Builder;

public class Employee {

    private String name;
    private String department;
    private String organization;
    private String fatherName;
    private String motherName;
    private String sisterName;
    private String brotherName;
    private String uncleName;
    private String auntyName;

    Employee(EmployeeBuilder employeeBuilder) {
        this.name = employeeBuilder.name;
        this.department = employeeBuilder.department;
        this.organization = employeeBuilder.organization;
        this.fatherName = employeeBuilder.fatherName;
        this.motherName = employeeBuilder.motherName;
        this.sisterName = employeeBuilder.sisterName;
        this.brotherName = employeeBuilder.brotherName;
        this.uncleName = employeeBuilder.uncleName;
        this.auntyName = employeeBuilder.auntyName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", organization='" + organization + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", sisterName='" + sisterName + '\'' +
                ", brotherName='" + brotherName + '\'' +
                ", uncleName='" + uncleName + '\'' +
                ", auntyName='" + auntyName + '\'' +
                '}';
    }

    static public class EmployeeBuilder {
        private String name;
        private String department;
        private String organization;
        private String fatherName;
        private String motherName;
        private String sisterName;
        private String brotherName;
        private String uncleName;
        private String auntyName;

        public static EmployeeBuilder builder() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public EmployeeBuilder setOrganization(String organization) {
            this.organization = organization;
            return this;

        }

        public EmployeeBuilder setFatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public EmployeeBuilder setMotherName(String motherName) {
            this.motherName = motherName;
            return this;
        }

        public EmployeeBuilder setSisterName(String sisterName) {
            this.sisterName = sisterName;
            return this;
        }

        public EmployeeBuilder setBrotherName(String brotherName) {
            this.brotherName = brotherName;
            return this;
        }

        public EmployeeBuilder setUncleName(String uncleName) {
            this.uncleName = uncleName;
            return this;
        }

        public EmployeeBuilder setAuntyName(String auntyName) {
            this.auntyName = auntyName;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }


}
