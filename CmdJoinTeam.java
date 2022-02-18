public class CmdJoinTeam extends RecordedCommand {
    private Employee e;
    private String teamName;

    @Override
    public void execute(String[] cmdParts) {
        try {
            if (cmdParts.length < 3) {
                throw new ExInsufficientArguments();
            }
            Company company = Company.getInstance();
            e = new Employee(cmdParts[2]);

            if (company.searchForEmployeeAlreadyInATeam(e)) {
                throw new ExEmployeeHasJoinedAnotherTeam();
            }
            if(!company.checkCurrentEmployee(e.getName())){
                throw new ExEmployeeNameNotExist();
            }
            teamName = cmdParts[2];
            if (!company.searchForTeamName(teamName)) {
                throw new ExTeamDoesNotExist();
            }
            company.addEmployeeToATeam(e, teamName);
            addUndoCommand(this);
            clearRedoList();

            System.out.println("Done.");
        } catch (ExInsufficientArguments e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeHasJoinedAnotherTeam e) {
            System.out.println(e.getMessage());
        } catch (ExTeamDoesNotExist e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeNameNotExist e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoMe() {

    }

    @Override
    public void redoMe() {

    }
}
