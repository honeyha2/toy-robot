package processor2;

import java.util.ArrayList;
import java.util.List;

import command.ICommand;
import lombok.Data;
import model.Robot;
import model.Table;

/**
 * hold common variable during different processors.
 *
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-25
 */
@Data
public class ContextHolder2 {
    protected String errmsg;
    protected String input;
    protected Robot robot;
    protected Table table;
    protected List<ICommand> commands;
    protected List<ICommand> ignoredCommands;

    public ContextHolder2(Table table, Robot robot) {
        this.robot = robot;
        this.table = table;
        this.errmsg = "";
        this.input = "";
        this.commands = new ArrayList<>();
        this.ignoredCommands = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ContextHolder2{" +
                "errmsg='" + errmsg + '\'' +
                ", input='" + input + '\'' +
                ", robot=" + robot +
                ", table=" + table +
                ", commands=" + commands +
                ", ignoredCommands=" + ignoredCommands +
                '}';
    }
}
