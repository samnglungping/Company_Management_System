import java.util.ArrayList;
import java.util.Collections; //Provides sorting

public class Company {
    private ArrayList<Employee> allEmployees;
    private ArrayList<Team> allTeams;
    private ArrayList<Project> allProjects;
    private ArrayList<Employee> alreadyInATeam;

    private static Company instance = new Company();

    // Constructor
    private Company() {
        allEmployees = new ArrayList<>();
        allTeams = new ArrayList<>();
        allProjects = new ArrayList<>();
        alreadyInATeam = new ArrayList<>();
    }

    public static Company getInstance() {
        return instance;
    }
    //Employee-Related Methods
    public Employee createEmployee(String n) { // See how it is called in main()
        Employee e = new Employee(n);
        allEmployees.add(e);
        Collections.sort(allEmployees); // allEmployees
        return e; // the return value is useful for later undoable command.
    }

    public void addEmployee(Employee e) {
        allEmployees.add(e);
        Collections.sort(allEmployees);
    }

    public void removeEmployee(Employee e) {
        allEmployees.remove(e);
    }

    public void listEmployees() {
        for (Employee e : allEmployees) {
            System.out.println(e.getName());
        }
    }

    public boolean searchForEmployeeName(String targetName) {
        for (Employee employee : allEmployees) {
            if(targetName.equals(employee.getName())){
                return true; //the target name already exist
            }
        }
        return false;
    }

    public boolean checkCurrentEmployee(String targetName){
        for (Employee employee : allEmployees) {
            if (targetName.equals(employee.getName())){
                return true; //target Name exist in company(Employee)
            }
        }
        return false;
    }
    //Team-Related Methods
    public Team createTeam(String sT, String sE) { // See how it is called in main()
        Employee e = Employee.searchEmployee(allEmployees, sE);
        e.setHasAssignedToATeam();
        Team t = new Team(sT, e);
        allTeams.add(t);
        alreadyInATeam.add(e);
        Collections.sort(allTeams); // allTeams
        return t; // the return value is useful for later undoable command.
    }
    
    public void listTeams() {
        Team.list(allTeams);
    }

	public void removeTeam(String tN, Employee e){
        if (Team.searchTeam(allTeams, tN)!=null) {
            allTeams.remove(Team.searchTeam(allTeams, tN));
        }
        if (Employee.searchEmployee(allEmployees, e.getName())!=null) {
            alreadyInATeam.remove(Employee.searchEmployee(allEmployees, e.getName()));
        }
        
    }

    public boolean searchForTeamName(String targetTeamName) {
        for (Team team : allTeams) {
            if(targetTeamName.equals(team.getName())){
                return true; //the target name already exist
            }
        }
        return false;
    }

    public boolean searchForEmployeeAlreadyInATeam(Employee target) {
        for (Employee employee : alreadyInATeam) {
            if (target.getName().equals(employee.getName())) {
                return true; //target employee has joined a team already
            }
        }
        return false;
    }

    public void addEmployeeToATeam(Employee e, String teamName){
        
    }

    //Project-Related Methods
    public Project createProject(String projectName, int estManpower) {
        Project p = new Project(projectName, estManpower);
        allProjects.add(p);
        Collections.sort(allProjects);
        return p;
    }

    public void removeProject(String projectName) {
        if (Project.searchProject(allProjects, projectName)!=null) {
            allProjects.remove(Project.searchProject(allProjects, projectName));
        }
    }

    public boolean searchForProject(String targetName) {
        for (Project project : allProjects) {
            if (targetName.equals(project.getName())) {
                return true;
            }
        }
        return false;
    }

    public void listProjects() {
        Project.list(allProjects);
    }
}
