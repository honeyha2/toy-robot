package command;

import model.Robot;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
public class Report implements ICommand {

    private Robot robot;

    public Report(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.report();
    }

    @Override
    public boolean checkFormat() {
        return true;
    }

    @Override
    public boolean isOnTableIfExecuted() {
        return true;
    }
}
