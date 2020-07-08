package com.basics;

import java.util.HashMap;

public class Employee {
    String kaka;
    String b;
    int t;

    public static void main(String[] args) {
        HashMap<Employee, Integer> map = new HashMap<>();
        Employee employee = new Employee();
        employee.kaka = "Maven";
        employee.b = "Sachin";
        employee.t = 10;
        Employee employee1 = new Employee();
        employee1.kaka = "Maven";
        employee1.b = "Sachin";
        employee1.t = 10;

        map.put(employee, 10);
        map.put(employee1, 20);
        System.out.println(map.size());

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Employee)) return false;
        if (obj == this) return true;
        return this.kaka.equals(((Employee) obj).kaka) && this.t == ((Employee) obj).t;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result + t;
        result = result + (kaka == null ? 0 : kaka.hashCode());

        return result;
    }

}
