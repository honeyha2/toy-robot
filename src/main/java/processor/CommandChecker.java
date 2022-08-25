package processor;

import java.util.List;

import command.ICommand;
import command.Place;
import lombok.Data;

/**
 * check constraints
 *
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
public class CommandChecker implements IProcessor {

    private List<ICommand> commands;
    // if check failed, there will be a error message.
    private String errmsg;

    public CommandChecker(List<ICommand> commands) {
        this.commands = commands;
    }

    /**
     * check constraints, such as command format, etc
     */
    @Override
    public void process() {
        if (commands == null || commands.size() == 0) {
            return;
        }

        if (!(commands.get(0) instanceof Place)) {
            errmsg = "fist command must be \"PLACE\"";
            return;
        }

        boolean checkFormat = commands.stream().allMatch(ICommand::checkFormat);
        if (!checkFormat) {
            errmsg = "command format checks failed";
            return;
        }
    }
}
