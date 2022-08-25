package model;

import java.util.ArrayList;
import java.util.List;

/**
 * represent direction that toy robot is facing.
 *
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
public enum Direction {
    SOUTH,
    NORTH,
    EAST,
    WEST;

    private static final List<Direction> clockwiseDirections = new ArrayList<>();

    static {
        clockwiseDirections.add(NORTH);
        clockwiseDirections.add(EAST);
        clockwiseDirections.add(SOUTH);
        clockwiseDirections.add(WEST);
    }

    /**
     * next direction by clockwise seq
     */
    public static Direction findNext(Direction direction) {
        int currentIndex = clockwiseDirections.indexOf(direction);
        int nextIndex = (currentIndex + 1) % clockwiseDirections.size();
        return clockwiseDirections.get(nextIndex);
    }

    /**
     * last direction by clockwise seq
     */
    public static Direction findLast(Direction direction) {
        int currentIndex = clockwiseDirections.indexOf(direction);
        int lastIndex = (currentIndex + clockwiseDirections.size() - 1) % clockwiseDirections.size();
        return clockwiseDirections.get(lastIndex);
    }

    @Override
    public String toString() {
        return name();
    }
}
