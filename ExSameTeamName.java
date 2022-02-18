public class ExSameTeamName extends Exception {

    private static final long serialVersionUID = 1L;

    public ExSameTeamName() {
        super("Team name already exists.");
    }

    public ExSameTeamName(String message) {
        super(message);
    }

}