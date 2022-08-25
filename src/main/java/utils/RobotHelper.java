package utils;

import java.util.Objects;

import model.Point;
import model.Robot;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
public class RobotHelper {

    /**
     * @return deep copied robot
     */
    public static Robot getANewRobotByDeepCopy(Robot robot) {
        Robot newRobot = new Robot();

        if (!Objects.isNull(robot.getPoint())) {
            Point point = new Point(robot.getPoint().getX(), robot.getPoint().getY());
            newRobot.setPoint(point);
        }

        if (!Objects.isNull(robot.getDirection())) {
            newRobot.setDirection(robot.getDirection());
        }

        return newRobot;
    }
}
