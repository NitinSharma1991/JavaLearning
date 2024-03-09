import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Maersk {


    public static void main(String[] args) {
        Emp emp = new Emp(1, "Nitin");
        Emp emp1 = new Emp(1, "SAchin");
        Emp emp2 = new Emp(2, "SAchin");
        Emp emp3 = new Emp(3, "Nitin");
        Emp emp4 = new Emp(4, "Nitin");

        List<Emp> empList = new ArrayList<>();
        empList.add(emp);
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);

        System.out.println(empList.stream().distinct().toList());
        Map<Integer, List<Emp>> map = empList.stream().collect(Collectors.groupingBy(Emp::getEmpId));
        System.out.println(map);
        System.out.println(map.entrySet().stream().filter(id -> id.getValue().size() == 1).collect(Collectors.toList()));

    }

}

class Emp {

    private int empId;
    private String name;

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return this.empId == emp.empId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.empId);
    }

    Emp(int empId, String name) {

        this.empId = empId;
        this.name = name;

    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}