package processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

/**
 * receive input from client
 *
 * @author lianchang <lianchang@kuaishou.com>
 * Created on 2022-08-24
 */
@Data
public class CommandReceiver implements IProcessor {

    /**
     * full text of client input
     */
    private String input;

    public CommandReceiver() {
        input = "";
    }

    /**
     * receive input from client, and save all the input to variable input
     */
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
                input += consoleInput + "\n";
            }
        }
    }
}
