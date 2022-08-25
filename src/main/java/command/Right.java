package command;

import lombok.AllArgsConstructor;
import model.Robot;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@AllArgsConstructor
public class Right implements ICommand {

    private Robot robot;

    @Override
    public void execute() {
        robot.right();
    }

    @Override
    public boolean isOnTableIfExecuted() {
        return true;
    }
}
