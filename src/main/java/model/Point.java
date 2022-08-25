package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * represent a point on the tale.
 *
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
@AllArgsConstructor
public class Point {
    int x;
    int y;
    // int z; // Point is a class. Easy to extend to 3d scene

    @Override
    public String toString() {
        return x + "," + y;
    }
}
