package utils;

import model.Robot;
import model.Table;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
public class TableHelper {

    public static boolean isRobotOnTable(Robot robot, Table table) {
        if (robot.getPoint().getX() <= table.getSorthEastEnd().getX()
                && robot.getPoint().getX() >= table.getSorthWestEnd().getX()
                && robot.getPoint().getY() <= table.getNorthWestEnd().getY()
                && robot.getPoint().getY() >= table.getSorthWestEnd().getY()) {
            return true;
        }
        return false;
    }
}
