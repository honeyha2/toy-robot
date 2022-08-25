package utils;

import model.Point;
import model.Robot;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
public class RobotHelper {

    public static Robot getANewRobotByDeepCopy(Robot robot) {
        Point point = new Point(robot.getPoint().getX(), robot.getPoint().getY());
        Robot newRobot = new Robot(point, robot.getDirection());
        return newRobot;
    }
}
