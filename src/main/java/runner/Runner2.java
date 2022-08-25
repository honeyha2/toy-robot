package runner;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

import model.Point;
import model.Robot;
import model.Table;
import processor2.CommandChecker2;
import processor2.CommandExecutor2;
import processor2.CommandReceiver2;
import processor2.CommandRecognizer2;
import processor2.ContextHolder2;
import processor2.Processor2;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-25
 */
public class Runner2 {

    /**
     * this main method seems pretty more clear than main of Runner.
     * as a caller, Runner2 just need to initalize some instances, and set the executing order of processors.
     * There is no need to care about input/output of each processor, which Runner does.
     */
    public static void main(String[] args) {
        Robot robot = new Robot();
        Table table = initTable();
        ContextHolder2 contextHolder2 = new ContextHolder2(table, robot);

        Processor2 commandReceiver2 = new CommandReceiver2(contextHolder2);
        Processor2 commandRecognizer2 = new CommandRecognizer2(contextHolder2);
        Processor2 commandChecker2 = new CommandChecker2(contextHolder2);
        Processor2 commandExecutor2 = new CommandExecutor2(contextHolder2);
        List<Processor2> processorChain =
                Lists.newArrayList(commandReceiver2, commandRecognizer2, commandChecker2, commandExecutor2);

        for (Processor2 processor2 : processorChain) {
            // if needs to debug, use this method
            // processor2.printContextHolder2();
            processor2.process();
            if (StringUtils.isNotBlank(contextHolder2.getErrmsg())) {
                System.out.println(contextHolder2.getErrmsg());
                break;
            }
        }

    }

    /**
     * define 4 end points of table.
     */
    public static Table initTable() {
        Point northEastEnd = new Point(5, 5);
        Point sorthEastEnd = new Point(5, 0);
        Point northWestEnd = new Point(0, 5);
        Point sorthWestEnd = new Point(0, 0);
        return new Table(northEastEnd, sorthEastEnd, northWestEnd, sorthWestEnd);
    }
}
