import java.util.HashSet;
import java.util.Set;

public class HashEmployee {
    public static void main(String[] args) {
        Set<Employee> employees = new HashSet<>();
        Employee emp1= new Employee("Duy",1);
        Employee emp2= new Employee("Tao",1);
        employees.add(emp1);
        System.out.println(emp1.equals(emp2));
        System.out.println(employees.contains(emp2));
        System.out.println(employees.size());
    }
}
