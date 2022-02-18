import java.util.*;

public class Project implements Comparable<Project> {
    private String projectName;
    private int estManPower;
    private Day dateSetup;
    private Team teamAssigned;
    private ArrayList<Employee> projectEmployees;

    // Constructor
    public Project(String projectName, int estManPower, Day dateSetup) {
        this.projectName = projectName;
        this.estManPower = estManPower;
        this.dateSetup = SystemDate.getInstance().clone();
        projectEmployees = new ArrayList<>();
    }

    // Constructor(Without dateSetup)
    public Project(String projectName, int estManPower) {
        this.projectName = projectName;
        this.estManPower = estManPower;
        projectEmployees = new ArrayList<>();

    }

    public String getName() {
        return projectName;
    }

    public int getEstManpower() {
        return estManPower;
    }

   
    public static void list(ArrayList<Project> list) {
        System.out.printf("%-9s%-14s%-13s%-13s%-13s\n", "Project", "Est manpower", "Team", "Start Day", "End Day");
        for (Project project : list) {
            System.out.printf("%-9s%s%-14s%-13s\n", project.projectName, project.estManPower, " man-days", project.printAssignedTeamName());
            
        }
    }

    public String printAssignedTeamName() {
        if (teamAssigned==null) {
            return "(Not Assigned)";
            
        } else {
        return this.teamAssigned.getName();
        }
    }
    @Override
    public int compareTo(Project another) {
        return this.projectName.compareTo(another.projectName);
    }

    public static Project searchProject(ArrayList<Project> allProjects, String projectName2) {
        for (Project project : allProjects) {
            if (project.getName().equals(projectName2)) {
                return project;
            }
        }
        return null;
    }

}
