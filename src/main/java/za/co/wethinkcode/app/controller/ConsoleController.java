package za.co.wethinkcode.app.controller;

import za.co.wethinkcode.app.core.GameController;
import za.co.wethinkcode.app.view.console.ConsoleView;

public class ConsoleController extends GameController {
    private ConsoleView _console;

    public ConsoleController() {
        super();
        System.out.println("Console controller running");
        this._console = new ConsoleView();
    }
}
