public class ExEmployeeHasJoinedAnotherTeam extends Exception {

    private static final long serialVersionUID = 1L;

    public ExEmployeeHasJoinedAnotherTeam() {
        super("Employee has joined a team already.");
    }

    public ExEmployeeHasJoinedAnotherTeam(String message) {
        super(message);
    }

}