package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
@AllArgsConstructor
public class Table {
    // four end points of the table.
    Point northEastEnd;
    Point sorthEastEnd;
    Point northWestEnd;
    Point sorthWestEnd;
}
