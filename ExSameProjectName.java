public class ExSameProjectName extends Exception {

    private static final long serialVersionUID = 1L;

    public ExSameProjectName() {
        super("Project code already exists.");
    }

    public ExSameProjectName(String message) {
        super(message);
    }

}