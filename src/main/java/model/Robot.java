package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * define attributes that robot has, and actions that robot can make.
 *
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Robot {

    // location of robot
    Point point;
    // facing of robot
    Direction direction;

    public void move() {
        moveOneStep(point, direction);
    }

    /**
     * move one step according to origin location and facing
     *
     * @param point location before move
     * @param direction facing before move
     */
    private void moveOneStep(Point point, Direction direction) {
        switch (direction) {
            case EAST:
                point.setX(point.getX() + 1);
                break;
            case WEST:
                point.setX(point.getX() - 1);
                break;
            case NORTH:
                point.setY(point.getY() + 1);
                break;
            case SOUTH:
                point.setY(point.getY() - 1);
                break;
        }
    }

    /**
     * rotate left 90 degrees
     */
    public void left() {
        direction = Direction.findLast(direction);
    }

    /**
     * rotate right 90 degrees
     */
    public void right() {
        direction = Direction.findNext(direction);
    }

    /**
     * @param targetPoint destination location
     * @param targetDirection destination facing
     */
    public void place(Point targetPoint, Direction targetDirection) {
        this.point = targetPoint;
        this.direction = targetDirection;
    }

    public void report() {
        System.out.println(point + "," + direction);
    }
}
