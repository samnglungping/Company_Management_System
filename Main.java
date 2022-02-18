import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Create Scanner for file name input
        Scanner in = new Scanner(System.in);

        System.out.print("Please input the file pathname: ");
        String filepathname = in.nextLine();

        Scanner inFile = new Scanner(new File(filepathname));

        // The first command in the file must be to set the system date
        // (eg. "startNewDay|01-Jan-2020"); and it cannot be undone
        String cmdLine1 = inFile.nextLine();
        String[] cmdLine1Parts = cmdLine1.split("\\|");
        System.out.println("\n> " + cmdLine1);
        SystemDate.createTheInstance(cmdLine1Parts[1]);

        // Reading Command in txt file
        while (inFile.hasNext()) {
            String cmdLine = inFile.nextLine().trim();

            // Blank lines exist in data file as separators. Skip them.
            if (cmdLine.equals("")) {
                continue;
            }

            System.out.println("\n> " + cmdLine);

            String[] cmdParts = cmdLine.split("\\|");
            if (cmdParts[0].equals("startNewDay")) {
                (new CmdStartNewDay()).execute(cmdParts);
            }
            // Hire
            else if (cmdParts[0].equals("hire")) {
                (new CmdHire()).execute(cmdParts);
            }
            // Listing Employees
            else if (cmdParts[0].equals("listEmployees")) {
                (new CmdListEmployees()).execute(cmdParts);
            }
            // Set Up Team
            else if (cmdParts[0].equals("setupTeam")) {
                (new CmdSetupTeams()).execute(cmdParts);
            }
            // Listing Teams
            else if (cmdParts[0].equals("listTeams")) {
                (new CmdListTeams()).execute(cmdParts);

            }
            // Create Project
            else if (cmdParts[0].equals("createProject")) {
                (new CmdCreateProject()).execute(cmdParts);
            }
            // List Project
            else if (cmdParts[0].equals("listProjects")) {
                (new CmdListProject()).execute(cmdParts);
            }
            else if (cmdParts[0].equals("joinTeam")){
                (new CmdJoinTeam()).execute(cmdParts);
            }
            // Undo
            else if (cmdParts[0].equals("undo")) {
                RecordedCommand.undoOneCommand();
            }
            // Redo
            else if (cmdParts[0].equals("redo")) {
                RecordedCommand.redoOneCommand();
            }

        }
        inFile.close();

        in.close();
    }
}