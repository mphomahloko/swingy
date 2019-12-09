package za.co.wethinkcode.app.view.console;

import java.awt.event.ActionListener;

import za.co.wethinkcode.app.view.SwingyView;
import za.co.wethinkcode.app.core.GameMap;

import java.util.Scanner;

public class ViewConsole implements SwingyView {
	private String _heroName;
	private String _heroType;
	
	public ViewConsole() {
		clearView();
		return ;
	}

	@Override
	public void iniView() {
		System.out.println("Welcome to Swingy.");
		System.out.println("1. New Game\n2. Continue ...\n3. Switch to GUI\n4. EXIT");
	    return ;
	}
	
	@Override
	public void newGameView() {
		Scanner prompt = new Scanner(System.in);
		System.out.println("Welcome to Swingy Let's build your Hero.");
		System.out.print("Enter Hero Name: ");
		_heroName = prompt.nextLine();
		// add more hero's
		System.out.println("Select Hero Type: \n" +
							"1. Witch");
		
		int inputChoice = prompt.nextInt();
		if (inputChoice == 1) {
			_heroType = "Witch";
		} else {
			_heroType = "OtherTypes";
		}
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
	public void drawMap(GameMap game) {
		clearView();
		System.out.print("\n");
		for (int i = 0; i < game.map.length; i += 1) {
			System.out.print("\t\t\t");
			for (int j = 0; j < game.map.length; j += 1) {
				System.out.print(game.map[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n\t1.move up\t2.move down\t3.move left\t4.move right");
		return ;
	}

    @Override
	public void alertMsg(String msg) {
		System.out.println(msg);
		return ;
	}
    
    @Override
	public void gameView() { return ; }
	
	@Override
    	public void addPlayersInterraction(ActionListener listensForAction) { return ; }
}
