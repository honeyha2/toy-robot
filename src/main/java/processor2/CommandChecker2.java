package processor2;

import command.Place;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-25
 */
public class CommandChecker2 extends Processor2 {
    public CommandChecker2(ContextHolder2 contextHolder2) {
        super(contextHolder2);
    }

    @Override
    public void process() {
        if (contextHolder2.commands == null || contextHolder2.commands.size() == 0) {
            return;
        }

        if (!(contextHolder2.commands.get(0) instanceof Place)) {
            contextHolder2.errmsg = "fist command must be \"PLACE\"";
            return;
        }

        /**
         * if there is some checks in the future, add code here
         */
    }
}
