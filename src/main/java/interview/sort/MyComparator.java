package interview.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class MyComparator {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(10);
        employee.setName(null);
        employee.setOrganization("Morgan");
        Map<Employee,Object> map = new HashMap<>();
        map.put(employee, employee.getName());
        System.out.println(map);
        list.add(employee);
//        Employee employee1 = new Employee();
//        employee1.setId(11);
//        employee1.setName("Nitin1");
//        employee1.setOrganization("Kaka");
//        list.add(employee1);
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);
//        list.sort(Comparator.comparing(o -> o.organization));
//        System.out.println(list);
//        list.sort(Comparator.comparing(o -> o.id));
//        System.out.println(list);
    }
}
