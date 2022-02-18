public class ExSameEmployeeName extends Exception {

    private static final long serialVersionUID = 1L;

    public ExSameEmployeeName() {
        super("Employee name already exists.");
    }

    public ExSameEmployeeName(String message) {
        super(message);
    }

}