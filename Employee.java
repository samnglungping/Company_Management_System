import java.util.*;

public class Employee implements Comparable<Employee> {
    private String name;
    private boolean hasAssignedToATeam;

    public Employee(String n) {
        name = n;// Set name
        hasAssignedToATeam = false;
    }

    public String getName() {
        return name;
    }

    public boolean getHasAssignedToATeam() {
        return hasAssignedToATeam;
    }

    public void setHasAssignedToATeam() {
        hasAssignedToATeam=true;
    }

    public static Employee searchEmployee(ArrayList<Employee> list, String nameToSearch) {
        for (Employee e : list) {
            if (e.getName().equals(nameToSearch)) {
                return e;
            }

        }
        return null; // search the arrayList for the employee with the given name
    }

    @Override
    public int compareTo(Employee another) {
        return this.name.compareTo(another.name);
    }
}
