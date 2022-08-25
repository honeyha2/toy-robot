package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        Table target = (Table) obj;
        return Objects.equals(northEastEnd, target.getNorthEastEnd()) && Objects
                .equals(sorthEastEnd, target.getSorthEastEnd()) && Objects
                .equals(northWestEnd, target.getNorthWestEnd()) && Objects
                .equals(sorthWestEnd, target.getSorthWestEnd());
    }
}
