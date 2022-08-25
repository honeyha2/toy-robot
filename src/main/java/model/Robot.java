package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
@AllArgsConstructor
public class Robot {

    Point point;
    Direction direction;

    public void move() {
        moveOneStep(point, direction);
    }


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

    public void left() {
        //        if (direction == null) {
        //            throw new Exception("无法left");
        //        }

        direction = Direction.findLast(direction);
    }

    public void right() {
        //        if (direction == null) {
        //            throw new Exception("无法right");
        //        }

        direction = Direction.findNext(direction);
    }

    public void place(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public void report() {
        System.out.println(point + "," + direction);
    }
}
