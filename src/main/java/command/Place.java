package command;

import lombok.AllArgsConstructor;
import model.Direction;
import model.Point;
import model.Robot;
import model.Table;
import utils.RobotHelper;
import utils.TableHelper;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@AllArgsConstructor
public class Place implements ICommand {
    private Point targetPoint;
    private Direction targetDirection;
    private Robot robot;
    private Table table;

    @Override
    public void execute() {
        robot.place(targetPoint, targetDirection);
    }

    @Override
    public boolean isOnTableIfExecuted() {
        Robot substituteRobot = RobotHelper.getANewRobotByDeepCopy(robot);
        substituteRobot.place(targetPoint, targetDirection);
        return TableHelper.isRobotOnTable(substituteRobot, table);
    }
}
