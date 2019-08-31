package za.co.wethinkcode.app.controller;

import java.util.Scanner;

import za.co.wethinkcode.app.core.GameController;
import za.co.wethinkcode.app.view.console.ConsoleView;

public class ConsoleController extends GameController {
    private ConsoleView _console;

    public ConsoleController() {
        super();
        this._console = new ConsoleView();
        Scanner state = new Scanner(System.in);

        int currentState = state.nextInt();
        if (currentState == 1) {
            System.out.println("you have to create your player.");
        }
        else if (currentState == 2) {
            System.out.println("You pressed 2.");
        }
        else {
            System.out.println("Invalid input.");
        }
    }
}
