package runner;

import org.springframework.util.StringUtils;

import model.Point;
import model.Robot;
import model.Table;
import processor.CommandChecker;
import processor.CommandExecutor;
import processor.CommandReceiver;
import processor.CommandRecognizer;

/**
 * program entrance
 *
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
public class Runner {

    /**
     * the call chain is: receive commands -> recognize commands -> check commands -> execute commands
     * output of each part will be input of its next part.
     */
    public static void main(String[] args) {
        CommandReceiver commandReceiver = new CommandReceiver();
        commandReceiver.process();

        // create toy robot without setting attributes, attributes will be set when place command executed.
        Robot toyRobot = new Robot();
        Table table = initTable();
        CommandRecognizer commandRecognizer = new CommandRecognizer(commandReceiver.getInput(), toyRobot, table);
        commandRecognizer.process();
        if (!StringUtils.isEmpty(commandRecognizer.getErrmsg())) {
            System.out.println(commandRecognizer.getErrmsg());
            return;
        }

        CommandChecker commandChecker = new CommandChecker(commandRecognizer.getCommands());
        commandChecker.process();
        if (!StringUtils.isEmpty(commandChecker.getErrmsg())) {
            System.out.println(commandChecker.getErrmsg());
            return;
        }

        CommandExecutor commandExecutor = new CommandExecutor(commandChecker.getCommands());
        commandExecutor.process();
        if (!commandExecutor.getIgnoredCommands().isEmpty()) {
            System.out.println("ignored commands: " + commandExecutor.getIgnoredCommands());
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
