package process;

import java.util.List;

import command.ICommand;
import command.Place;
import lombok.AllArgsConstructor;
import lombok.Data;
import model.Robot;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
@AllArgsConstructor
public class CommandIgnorer implements IProcessor {
    private List<ICommand> commands;
    private Robot robot;

    @Override
    public void process() {

    }


}
