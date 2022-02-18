public class ExInvalidManPower extends Exception{

    private static final long serialVersionUID = 1L;

    public ExInvalidManPower() {
        super("Estimated manpower should not be zero or negative.\nConsider changing 0 to a positive non-zero amount.");
    }

    public ExInvalidManPower(String message) {
        super(message);
    }
}
