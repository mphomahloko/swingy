package za.co.wethinkcode.app.view.console;

import za.co.wethinkcode.app.view.SwingyView;

import java.awt.event.ActionListener;
import java.util.Scanner;

public class ViewConsole implements SwingyView {
    private String _heroName;
    private String _heroType;
    
    public ViewConsole() {
		return ;
    }

    @Override
    public void iniView() {
        System.out.println("Welcome to Swingy.");
		System.out.println("1. New Game.\n2. Continue...");
        return ;
    }

    @Override
	public void newGameView() {
        Scanner prompt = new Scanner(System.in);
		System.out.print("Enter Hero Name: ");
        _heroName = prompt.nextLine();
        System.out.print("Enter Hero Type: ");
        _heroType = prompt.nextLine();
        
        return ;
	}

    @Override
    public String getHeroName() {
        return _heroName;
    }

    @Override
    public String getHeroType() {
        return _heroType;
    }

    @Override
    public void continueView() {
        System.out.println("Previously saved games.");
        return ;
    }

    @Override
	public void clearView() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

    @Override
    public void addPlayersInterraction(ActionListener listensForAction) {
        return ;
    }
}
