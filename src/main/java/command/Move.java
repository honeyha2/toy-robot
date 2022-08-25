package command;

import java.util.Objects;

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
    public boolean isOnTableIfExecuted() {
        // deep copy
        Robot substituteRobot = RobotHelper.getANewRobotByDeepCopy(robot);
        substituteRobot.move();
        return TableHelper.isRobotOnTable(substituteRobot, table);
    }

    /**
     * for unit test
     */
    @Override
    public boolean equals(Object obj) {
        Move target = (Move) obj;
        return Objects.equals(this.robot, target.robot) && Objects.equals(this.table, target.table);
    }
}
