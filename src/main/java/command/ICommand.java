package command;

/**
 * command design pattern is adopted, which is scalable to add new commands.
 *
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
public interface ICommand {

    // execute command
    void execute();

    // check command format
    boolean checkFormat();

    // calculate whether robot is on the table if this command is executed.
    boolean isOnTableIfExecuted();
}
