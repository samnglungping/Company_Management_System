import java.util.*;

public class Team implements Comparable<Team> {
    private String teamName;
    private Employee head;
    private Day dateSetup; // the date this team was setup
    private ArrayList<Employee> allTeamMembers;

    public Team(String n, Employee hd) {
        teamName = n;
        head = hd;
        dateSetup = SystemDate.getInstance().clone();
        allTeamMembers = new ArrayList<>();
        // Set teamName, head, setup date
    }

    public static void list(ArrayList<Team> list) {
        // Learn: "-" means left-aligned
        System.out.printf("%-15s%-10s%-14s%-20s\n", "Team Name", "Leader", "Setup Date", "Members");
        for (Team t : list){
            System.out.printf("%-15s%-10s%-14s", t.teamName, t.head.getName(), t.dateSetup);
            t.getTeamMembersName();
            System.out.println();
        }
                                                                                                    
    }

    public String getName() {
        return teamName;
    }

    public void getTeamMembersName() {
        if (allTeamMembers.isEmpty()) {
            System.out.print("(no member)");

        } else {
            for (Employee employee : allTeamMembers) {
                System.out.printf("%s ", employee.getName());
            }
        }
    }

    @Override
    public int compareTo(Team another) {
        return this.teamName.compareTo(another.teamName);
    }

    public static Team searchTeam(ArrayList<Team> list, String teamNameToSearch) {
        for (Team team : list) {
            if (team.getName().equals(teamNameToSearch)) {
                return team;
            }
        }
        return null;
    }

    public void addEmployeeToATeam(Employee e) {
        allTeamMembers.add(e);
    }
}
