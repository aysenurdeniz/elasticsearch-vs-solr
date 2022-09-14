package cmdCommand;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author aysenurdeniz
 */
public class CmdCommand {

    public CmdCommand() {
    }

    public void excCommand(String newCommand){
        Runtime rt = Runtime.getRuntime();
        String[] command = new String[]{"cmd.exe", "/c", newCommand};
        System.out.println(Arrays.toString(command));
        try {
            rt.exec(command);
            Wait(10000);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void IndexingCommand(String command) {
        timer.Timer.start();
        excCommand(command);
        timer.Timer.stop();
        System.out.println("----------------------\nGeçen Süre:" + timer.Timer.getElapsedMilliseconds());
    }

    public static void Wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

//    public void openInChrome(String portNumber){
//        System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
//        driver.get("http://localhost:" + portNumber);
//    }
}
