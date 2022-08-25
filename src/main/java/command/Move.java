package command;

import lombok.AllArgsConstructor;
import model.Robot;
import model.Table;
import utils.RobotHelper;
import utils.TableHelper;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@AllArgsConstructor
public class Move implements ICommand {

    private Robot robot;
    private Table table;

    @Override
    public void execute() {
        robot.move();
    }

    @Override
    public boolean checkFormat() {
        return true;
    }

    @Override
    public boolean isOnTableIfExecuted() {
        // create a new substitute robot to act. deep copy
        Robot substituteRobot = RobotHelper.getANewRobotByDeepCopy(robot);
        substituteRobot.move();
        return TableHelper.isRobotOnTable(substituteRobot, table);
    }

}
