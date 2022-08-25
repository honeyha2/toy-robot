package processor;

import java.util.ArrayList;
import java.util.List;

import command.ICommand;
import command.Left;
import command.Move;
import command.Place;
import command.Report;
import command.Right;
import constant.Command;
import lombok.Data;
import model.Direction;
import model.Point;
import model.Robot;
import model.Table;

/**
 * recognize the commands, convert them from String to ICommand
 *
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
public class CommandRecognizer implements IProcessor {

    private String input;
    // recognized result
    private List<ICommand> commands;
    // if a line of input string can not be recognized, it will have a error message
    private String errmsg;
    private Robot robot;
    private Table table;

    public CommandRecognizer(String input, Robot robot, Table table) {
        this.input = input;
        this.robot = robot;
        this.table = table;
        commands = new ArrayList<>();
    }

    @Override
    public void process() {
        String[] commandStrings = input.split("\n");

        for (String commandString : commandStrings) {
            parse(commandString);
        }
    }

    /**
     * steps:
     * 1. split the commandString by space char
     * 2. use switch-case to match the command, if hit, create a new instance of the command.
     * 3. place command is a little more special, because of the format of it is a little more complex.
     * if recognized failed, the error message will be not empty.
     */
    private void parse(String commandString) {
        String[] commandSplits = commandString.split(" ");
        switch (commandSplits[0]) {
            case Command.COMMAND_MOVE:
                commands.add(new Move(robot, table));
                break;
            case Command.COMMAND_LEFT:
                commands.add(new Left(robot));
                break;
            case Command.COMMAND_RIGHT:
                commands.add(new Right(robot));
                break;
            case Command.COMMAND_REPORT:
                commands.add(new Report(robot));
                break;
            case Command.COMMAND_PLACE:
                if (commandSplits.length != 2) {
                    errmsg = Command.COMMAND_PLACE + " format wrong";
                }

                String[] tempSplits = commandSplits[1].split(",");
                if (tempSplits.length != 3) {
                    errmsg = Command.COMMAND_PLACE + " format wrong";
                }

                try {
                    int x = Integer.parseInt(tempSplits[0]);
                    int y = Integer.parseInt(tempSplits[1]);
                    Point targetPoint = new Point(x, y);
                    Direction targetDirection = Direction.valueOf(tempSplits[2]);
                    commands.add(new Place(targetPoint, targetDirection, robot, table));
                } catch (Exception e) {
                    errmsg = Command.COMMAND_PLACE + " format wrong" + '\n' + e;
                }
                break;
            default:
                errmsg = commandSplits[0] + " is not a valid command";
                break;
        }
    }
}
