

public class CmdStartNewDay extends RecordedCommand{

    private String newDay;
    private String originalDay;
    private SystemDate systemDate;
    @Override
    public void execute(String[] cmdParts) {
        systemDate=SystemDate.getInstance();
        originalDay=systemDate.toString();
        newDay = cmdParts[1];

        systemDate.set(newDay);

        
        addUndoCommand(this);
        clearRedoList();   
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        systemDate=SystemDate.getInstance();
        systemDate.set(originalDay);

        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        systemDate=SystemDate.getInstance();
        
        systemDate.set(newDay);
		addUndoCommand(this);


    }
    
}
