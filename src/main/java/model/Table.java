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
    Point northEastEnd;
    Point sorthEastEnd;
    Point northWestEnd;
    Point sorthWestEnd;
}
