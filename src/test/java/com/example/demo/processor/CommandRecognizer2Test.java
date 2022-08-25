package com.example.demo.processor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.assertj.core.util.Lists;
import org.junit.Test;

import command.Move;
import model.Point;
import model.Robot;
import model.Table;
import processor2.CommandRecognizer2;
import processor2.ContextHolder2;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
public class CommandRecognizer2Test {

    @Test
    public void testProcess() {
        ContextHolder2 contextHolder2 = initContextHolder2();
        CommandRecognizer2 commandRecognizer2 = new CommandRecognizer2(contextHolder2);
        commandRecognizer2.process();

        assertThat(contextHolder2.getCommands(), is(Lists.newArrayList(new Move(new Robot(), initTable()))));
    }

    /**
     * define 4 end points of table.
     */
    private Table initTable() {
        Point northEastEnd = new Point(5, 5);
        Point sorthEastEnd = new Point(5, 0);
        Point northWestEnd = new Point(0, 5);
        Point sorthWestEnd = new Point(0, 0);
        return new Table(northEastEnd, sorthEastEnd, northWestEnd, sorthWestEnd);
    }

    private ContextHolder2 initContextHolder2() {
        Robot robot = new Robot();
        Table table = initTable();
        ContextHolder2 contextHolder2 = new ContextHolder2(table, robot);

        contextHolder2.setInput("MOVE");
        return contextHolder2;
    }
}
