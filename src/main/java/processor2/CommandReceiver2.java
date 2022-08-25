package processor2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-25
 */
public class CommandReceiver2 extends Processor2 {

    public CommandReceiver2(ContextHolder2 contextHolder2) {
        super(contextHolder2);
    }

    @Override
    public void process() {
        System.out.println("Input commands to control toy robot");
        System.out.println("PLACE X,Y,NORTH | SOUTH | EAST | WEST, MOVE, LEFT, RIGHT, REPORT, EXIT");

        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isRunning = true;
        while (isRunning) {
            String consoleInput = null;
            try {
                consoleInput = String.valueOf(userInputReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (StringUtils.equals(consoleInput, "")) {
                isRunning = false;
                break;
            } else {
                contextHolder2.input += consoleInput + "\n";
            }
        }
    }
}
