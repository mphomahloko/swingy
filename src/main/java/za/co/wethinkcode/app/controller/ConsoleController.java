package za.co.wethinkcode.app.controller;

import java.util.Scanner;

import za.co.wethinkcode.app.controller.GameController;
import za.co.wethinkcode.app.view.console.ConsoleView;

public class ConsoleController extends GameController {
    private ConsoleView _console;

    public ConsoleController() {
        super();
        this._console = new ConsoleView();
        Scanner inputGameState = new Scanner(System.in);

        int currentState = inputGameState.nextInt();
        // inputGameState.close();
        if (currentState == 1) {
            createHero();
        }else if (currentState == 2) {
            System.out.println("You pressed " + currentState);
        }else {
            System.out.println("Invalid input.");
        }
    }
}
