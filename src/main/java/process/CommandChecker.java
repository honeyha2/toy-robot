package process;

import java.util.List;

import command.ICommand;
import command.Place;
import lombok.Data;
import model.Robot;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
public class CommandChecker implements IProcessor {

    private List<ICommand> commands;
    private Robot robot;
    private String errmsg;

    public CommandChecker(List<ICommand> commands, Robot robot) {
        this.commands = commands;
        this.robot = robot;
    }

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
