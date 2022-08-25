package process;

import java.util.List;

import command.ICommand;
import command.Left;
import command.Move;
import command.Report;
import command.Right;
import lombok.Data;
import model.Robot;
import model.Table;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
public class CommandRecognizer implements IProcessor {

    private String input;
    private List<ICommand> commands;
    private String errmsg;
    private Robot robot;
    private Table table;

    public CommandRecognizer(String input) {
        this.input = input;
    }

    @Override
    public void process() {
        String[] commandStrings = input.split("\n");

        for (String commandString : commandStrings) {
            switch (commandString) {
                case "MOVE":
                    commands.add(new Move(robot, table));
                case "LEFT":
                    commands.add(new Left(robot));
                case "RIGHT":
                    commands.add(new Right(robot));
                case "REPORT":
                    commands.add(new Report(robot));
            }
            if (commandString.startsWith("PLACE")) {
                // commands.add(new Place(, Direction.EAST, this.robot));
            }
        }
    }
}
