package process;

import java.util.List;

import command.ICommand;
import command.Place;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
@AllArgsConstructor
public class CommandExecutor implements IProcessor {

    private List<ICommand> commands;
    private List<ICommand> ignoredCommands;

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
