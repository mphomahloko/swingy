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
	}

	@Override
	public void iniView() {
		System.out.println("Welcome to Swingy.");
		System.out.println("1. New Game\n2. Continue ...\n3. Switch to GUI\n4. EXIT");
	}
	
	@Override
	public void newGameView() {
		Scanner prompt = new Scanner(System.in);
		System.out.println("Welcome to Swingy Let's build your Hero.");
		System.out.print("Enter Hero Name: ");
		_heroName = prompt.nextLine();
		// add more hero's
		System.out.println("Select Hero Type: \n" +
							"1. Witch"+
							"\n2. Giant"+
							"\n3. Goblin");
		
		int inputChoice = prompt.nextInt();
		if (inputChoice == 1) {
			_heroType = "Witch";
		}
		if (inputChoice == 2) {
			_heroType = "Giant";
		}
		if (inputChoice == 3) {
			_heroType = "Goblin";
		}
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
	}

	@Override
	public void clearView() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	@Override
	public void drawMap(GameMap game) {
		clearView();
		System.out.println("\t\t\t\033[1;91mSWINGY\033[0m");
		System.out.println("\t\033[1;91mPlayer Stats\033[0m");
		System.out.println(game.hero);
		System.out.println("\t\033[1;91mGame Play\033[0m");
		System.out.print("\n");
		for (int i = 0; i < game.map.length; i += 1) {
			System.out.print("\t");
			for (int j = 0; j < game.map[0].length; j += 1) {
				System.out.print(game.map[i][j]);
			}
			System.out.println();
		}
		System.out.println("\nINSTRUCTIONS\t1. UP\t2.DOWN\t3.LEFT\t4.RIGHT\t5.HOME SCREEN");
	}

	public void runOrFight(GameMap game) {
		Scanner choice = new Scanner(System.in);
		try {
			System.out.println("\n\t1. Run\t2.Fight");
			int inputChoice = choice.nextInt();
			if (inputChoice == 1) {
				game.fleeEnemy();
				return ;
			}
			if (inputChoice == 2) {
				game.fightEnemy();
				return ;
			}
			System.out.println("invalid Input");
			runOrFight(game);
		} catch (Exception e) {
			System.out.println("invalid Input");
			runOrFight(game);
		}
	}
	
	@Override
	public void alertMsg(String msg) {
		System.out.println(msg);
	}

	@Override
	public void gameView() {}
	
	@Override
	public void addPlayersInteraction(ActionListener listensForAction) {}
}
