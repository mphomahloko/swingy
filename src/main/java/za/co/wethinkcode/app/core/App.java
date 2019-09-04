package za.co.wethinkcode.app.core;

/**
 *  Entry point
 */

public class App {
    public static void main(String [] args) {
        try {
            if (args[0].equals("console")) {
                // new ConsoleController();
            }else if (args[0].equals("gui")) {
                // new GUIController();
            }else {
                throw new Exception();
            }
        }catch(Exception e) {
            System.out.println("Please choose weather to run in gui or console.");
        }
    }
}
