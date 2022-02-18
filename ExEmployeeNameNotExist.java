public class ExEmployeeNameNotExist extends Exception {

    private static final long serialVersionUID = 1L;

    public ExEmployeeNameNotExist() {
        super("Employee name does not exist.");
    }

    public ExEmployeeNameNotExist(String message) {
        super(message);
    }

}