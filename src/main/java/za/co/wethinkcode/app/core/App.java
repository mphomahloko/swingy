package za.co.wethinkcode.app.core;

import za.co.wethinkcode.app.controller.SwingyController;
import za.co.wethinkcode.app.model.SwingyModel;
import za.co.wethinkcode.app.view.SwingyView;

/**
 *  Entry point
 */

public class App {
    public static void main(String [] args) {
        try {
            if (args[0].equals("console") || args[0].equals("gui")) {
                SwingyModel model = new SwingyModel();
                SwingyView view = new SwingyView();
                SwingyController controller = new SwingyController(model, view);
                if (args[0].equals("gui")) {
                    controller.guiInterraction();
                }else{
                    controller.consoleInterraction();
                }
            }else {
                throw new Exception();
            }
        }catch(Exception e) {
            System.out.println("Please choose weather to run in gui or console.");
        }

        return ;
    }
}
