package runner;

import org.springframework.util.StringUtils;

import model.Point;
import model.Robot;
import model.Table;
import process.CommandChecker;
import process.CommandExecutor;
import process.CommandIgnorer;
import process.CommandReceiver;
import process.CommandRecognizer;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
public class Runner {
    public static void main(String[] args) {
        CommandReceiver commandReceiver = new CommandReceiver();
        commandReceiver.process();

        CommandRecognizer commandRecognizer = new CommandRecognizer(commandReceiver.getInput());
        commandRecognizer.process();
        if (!StringUtils.isEmpty(commandRecognizer.getErrmsg())) {
            System.out.println(commandRecognizer.getErrmsg());
            return;
        }

        // fixme:there may be some problems about new Robot() ...
        Robot robot = new Robot();
        Table table = initTable();
        CommandChecker commandChecker = new CommandChecker(commandRecognizer.getCommands(), robot);
        commandChecker.process();
        if (!StringUtils.isEmpty(commandChecker.getErrmsg())) {
            System.out.println(commandChecker.getErrmsg());
            return;
        }

        CommandIgnorer commandIgnorer = new CommandIgnorer(commandChecker.getCommands(), robot);
        commandIgnorer.process();

        CommandExecutor commandExecutor = new CommandExecutor(commandIgnorer.getCommands(), robot);
        commandExecutor.process();
    }

    public static Table initTable() {
        Point northEastEnd = new Point(5, 5);
        Point sorthEastEnd = new Point(5, 0);
        Point northWestEnd = new Point(0, 5);
        Point sorthWestEnd = new Point(0, 0);
        return new Table(northEastEnd, sorthEastEnd, northWestEnd, sorthWestEnd);
    }
}
