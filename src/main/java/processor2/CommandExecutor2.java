package processor2;

import java.util.List;

import command.ICommand;
import command.Place;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-25
 */
public class CommandExecutor2 extends Processor2 {
    public CommandExecutor2(ContextHolder2 contextHolder2) {
        super(contextHolder2);
    }

    @Override
    public void process() {
        int lastIndexOfPlace = getLastIndexOfValidPlace(contextHolder2.commands);
        if (lastIndexOfPlace >= 0) {
            contextHolder2.commands = contextHolder2.commands.subList(lastIndexOfPlace, contextHolder2.commands.size());
            contextHolder2.ignoredCommands.addAll(contextHolder2.commands.subList(0, lastIndexOfPlace));
        }

        for (ICommand command : contextHolder2.commands) {
            if (command.isOnTableIfExecuted()) {
                command.execute();
            } else {
                contextHolder2.ignoredCommands.add(command);
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
