public class CmdSetupTeams extends RecordedCommand {
    private String teamName;
    private Employee head;

    @Override
    public void execute(String[] cmdParts) {
        try {
            if (cmdParts.length<3) {
                throw new ExInsufficientArguments();
            }

            Company company = Company.getInstance();
            teamName = cmdParts[1];
            
            if (company.searchForTeamName(teamName)){
                throw new ExSameTeamName();
            }

            head = new Employee(cmdParts[2]);
            
            if (!company.searchForEmployeeName(head.getName())) {
                throw new ExEmployeeNameNotExist();
            }

            if (company.searchForEmployeeAlreadyInATeam(head)){
                throw new ExEmployeeHasJoinedAnotherTeam();
            }

            company.createTeam(teamName, head.getName());

            addUndoCommand(this);
            clearRedoList();

            System.out.println("Done.");
        } catch (ExInsufficientArguments e) {
            System.out.println(e.getMessage());
        } catch (ExSameTeamName e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeNameNotExist e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeHasJoinedAnotherTeam e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void undoMe() {
        Company company = Company.getInstance();
        company.removeTeam(teamName, head);
        addRedoCommand(this);

    }

    @Override
    public void redoMe() {

        Company company = Company.getInstance();

        company.createTeam(teamName, head.getName());
        addUndoCommand(this);

    }

}
