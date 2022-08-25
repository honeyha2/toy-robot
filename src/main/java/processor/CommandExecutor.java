package processor;

import java.util.ArrayList;
import java.util.List;

import command.ICommand;
import command.Place;
import lombok.Data;

/**
 * execute the commands, while ignore the commands which cause the robot to fall
 *
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
public class CommandExecutor implements IProcessor {

    private List<ICommand> commands;
    private List<ICommand> ignoredCommands;

    public CommandExecutor(List<ICommand> commands) {
        this.commands = commands;
        ignoredCommands = new ArrayList<>();
    }

    /**
     * steps:
     * 1. ignore the commands util a valid place command.
     * 2. traverse the remained commands, execute the command which makes toy robot still on table if executed.
     */
    @Override
    public void process() {
        int lastIndexOfPlace = getLastIndexOfValidPlace(commands);
        if (lastIndexOfPlace >= 0) {
            commands = commands.subList(lastIndexOfPlace, commands.size());
            ignoredCommands.addAll(commands.subList(0, lastIndexOfPlace));
        }

        for (ICommand command : commands) {
            if (command.isOnTableIfExecuted()) {
                command.execute();
            } else {
                ignoredCommands.add(command);
            }
        }
    }

    /**
     * traverse the command list and find the last index of a valid place command
     *
     * @param commands all commands from client input
     * @return lastIndexOfPlace
     */
    private int getLastIndexOfValidPlace(List<ICommand> commands) {
        int lastIndexOfPlace = -1;
        for (int i = commands.size() - 1; i >= 0; i--) {
            if (commands.get(i) instanceof Place && commands.get(i).isOnTableIfExecuted()) {
                lastIndexOfPlace = i;
            }
        }
        return lastIndexOfPlace;
    }
}
