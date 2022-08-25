package processor2;

import command.Left;
import command.Move;
import command.Place;
import command.Report;
import command.Right;
import constant.Command;
import model.Direction;
import model.Point;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-25
 */
public class CommandRecognizer2 extends Processor2 {
    public CommandRecognizer2(ContextHolder2 contextHolder2) {
        super(contextHolder2);
    }

    @Override
    public void process() {
        String[] commandStrings = contextHolder2.input.split("\n");

        for (String commandString : commandStrings) {
            if (!parse(commandString)) {
                return;
            }
        }
    }

    /**
     * steps:
     * 1. split the commandString by space char
     * 2. use switch-case to match the command, if hit, create a new instance of the command.
     * 3. place command is a little more special, because of the format of it is a little more complex.
     * if recognized failed, the error message will be not empty.
     */
    private boolean parse(String commandString) {
        String[] commandSplits = commandString.split(" ");
        switch (commandSplits[0]) {
            case Command.COMMAND_MOVE:
                contextHolder2.commands.add(new Move(contextHolder2.robot, contextHolder2.table));
                return true;
            case Command.COMMAND_LEFT:
                contextHolder2.commands.add(new Left(contextHolder2.robot));
                return true;
            case Command.COMMAND_RIGHT:
                contextHolder2.commands.add(new Right(contextHolder2.robot));
                return true;
            case Command.COMMAND_REPORT:
                contextHolder2.commands.add(new Report(contextHolder2.robot));
                return true;
            case Command.COMMAND_PLACE:
                if (commandSplits.length != 2) {
                    contextHolder2.errmsg = Command.COMMAND_PLACE + " format wrong";
                    return false;
                }

                String[] tempSplits = commandSplits[1].split(",");
                if (tempSplits.length != 3) {
                    contextHolder2.errmsg = Command.COMMAND_PLACE + " format wrong";
                    return false;
                }

                try {
                    int x = Integer.parseInt(tempSplits[0]);
                    int y = Integer.parseInt(tempSplits[1]);
                    Point targetPoint = new Point(x, y);
                    Direction targetDirection = Direction.valueOf(tempSplits[2]);
                    contextHolder2.commands
                            .add(new Place(targetPoint, targetDirection, contextHolder2.robot, contextHolder2.table));
                } catch (Exception e) {
                    contextHolder2.errmsg = Command.COMMAND_PLACE + " format wrong" + '\n' + e;
                    return false;
                }
                return true;
            default:
                contextHolder2.errmsg = commandSplits[0] + " is not a valid command";
                return false;
        }
    }
}
