package za.co.wethinkcode.app.core;

import java.sql.SQLException;

import za.co.wethinkcode.app.controller.SwingyController;
import za.co.wethinkcode.app.model.SwingyModel;
import za.co.wethinkcode.app.view.SwingyView;
import za.co.wethinkcode.app.view.gui.ViewGUI;
import za.co.wethinkcode.app.view.console.ViewConsole;

public class App {
    public static void main(String [] args) {
        
        try {
            if (args[0].equals("console") || args[0].equals("gui")) {
                SwingyModel model = new SwingyModel();
                SwingyView view;
                if (args[0].equals("gui")) {
                    view = new ViewGUI();
                }else{
                    view = new ViewConsole();
                }
                SwingyController controller = new SwingyController(model, view);
                if (args[0].equals("gui")) {
                    controller.guiInterraction();
                }else{
                    controller.consoleInterraction();
                }
            }else {
                throw new Exception();
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            System.out.println("Please choose weather to run in gui or console.");
        }

        return ;
    }
}
