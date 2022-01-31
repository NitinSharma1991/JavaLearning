package interview.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



class Comparator1 {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(10);
        employee.setName("Nitin");
        employee.setOrganization("Morgan");
        list.add(employee);
        Employee employee1 = new Employee();
        employee1.setId(11);
        employee1.setName("Nitin1");
        employee1.setOrganization("Kaka");
        list.add(employee1);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        list.sort(Comparator.comparing(o -> o.organization));
        System.out.println(list);
        list.sort(Comparator.comparing(o -> o.id));
        System.out.println(list);
    }
}
