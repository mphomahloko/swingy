package za.co.wethinkcode.app.view.console;

import java.awt.event.ActionListener;

import za.co.wethinkcode.app.view.SwingyView;

public class ConsoleView implements SwingyView {
    public ConsoleView() {
        System.out.println("Welcome to Swingy.\n");
        System.out.println("1. New Game.");
        System.out.println("2. Continue...");
        return ;
    }

	@Override
	public void addPlayersInterraction(ActionListener listensForAction) {
		
	}
}
