public class CmdCreateProject extends RecordedCommand {
    private String projectName;
    private int estManPowers;

    @Override
    public void execute(String[] cmdParts) {
        try {
            Company company = Company.getInstance();

            if (cmdParts.length < 3) {
                throw new ExInsufficientArguments();
            }

            projectName = cmdParts[1];
            estManPowers = Integer.parseInt(cmdParts[2]);

            if (company.searchForProject(projectName)) {
                throw new ExSameProjectName();
            }

            if (estManPowers<=0) {
                throw new ExInvalidManPower();
            }

            company.createProject(projectName, estManPowers);
            addUndoCommand(this);
            clearRedoList();

            System.out.println("Done.");
        } catch (ExInsufficientArguments e) {
            System.out.println(e.getMessage());
        } catch (ExSameProjectName e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format -- Please enter an integer.");
        } catch (ExInvalidManPower e) {
            System.out.println("Estimated manpower should not be zero or negative.\nConsider changing " + cmdParts[2] + " to a positive non-zero amount.");
        }
    }

    @Override
    public void undoMe() {
        Company company = Company.getInstance();
        company.removeProject(projectName);
        addRedoCommand(this);

    }

    @Override
    public void redoMe() {
        Company company = Company.getInstance();
        company.createProject(projectName, estManPowers);
        addUndoCommand(this);

    }
}
