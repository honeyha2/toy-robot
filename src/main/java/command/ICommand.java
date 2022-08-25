package command;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
public interface ICommand {
    /**
     * command design pattern is adopted, which is scalable to add new commands
     */

    // used for command executor to call
    void execute();

    // used for command checker to call
    boolean checkFormat();

    // used for command executor to call to judge whether ignore
    boolean isOnTableIfExecuted();
}
