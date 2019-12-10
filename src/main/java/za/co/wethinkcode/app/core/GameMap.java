package za.co.wethinkcode.app.core;

import za.co.wethinkcode.app.model.Hero;
import za.co.wethinkcode.app.view.SwingyView;
import za.co.wethinkcode.app.view.console.ViewConsole;

import java.util.Scanner;

public class GameMap {
	public String[][] map;
	public SwingyView view;
	public Hero hero;
	private Integer[] previousPos;
	public boolean gameState;

	public GameMap(Hero hero, SwingyView view) {
		this.hero = hero;
		previousPos = new Integer[2];
		previousPos[0] = hero.getHeroX();
		previousPos[1] = hero.getHeroY();

		// rough sketch
		this.map = new String[20][20];
		this.view = view;
		_renderMap();
		return ;
	}

	private void _renderMap() {
		for (int i = 0; i < this.map.length; i += 1) {
			for (int j = 0; j < this.map.length; j += 1) {
				this.map[i][j] = ".";
			}
		}
		// enermy class to randomly place an enermy
		this.map[6][10] = "E";
		placePlayer();
		return ;
	}

	public void placePlayer() {
		if (this.map.length <= hero.getHeroY() || this.map[0].length <= hero.getHeroX() || hero.getHeroY() < 0 || hero.getHeroX() < 0) {
			gameState = false;
			hero.setHeroX(20 / 2);
			hero.setHeroY(20 / 2);
			this.map[hero.getHeroY()][hero.getHeroX()] = "P";
			if (view instanceof ViewConsole) {
				view.clearView();
				return ;
			}
			view.alertMsg("You Win");
			view.clearView();
			view.iniView();
			return ;
		}
		if (this.map[hero.getHeroY()][hero.getHeroX()] == "E") {
			view.alertMsg("You have Encounterd an enermy");
			_fightOrRunSimulation();  
		}
		this.map[hero.getHeroY()][hero.getHeroX()] = "P";
		return ;
	}

	public void moveRight() {
		hero.setHeroX(hero.getHeroX() + 1);
		_renderMap();
		view.drawMap(this);
		return ;
	}

	public void moveLeft() {
		hero.setHeroX(hero.getHeroX() - 1);
		_renderMap();
		view.drawMap(this);
		return ;
	}

	public void moveDown() {
		hero.setHeroY(hero.getHeroY() + 1);
		_renderMap();
		view.drawMap(this);
		return ;
	}

	public void moveUp() {
		hero.setHeroY(hero.getHeroY() - 1);
		_renderMap();
		view.drawMap(this);
		return ;
	}

	private void _fightOrRunSimulation() {
		if (view instanceof ViewConsole) {
			ViewConsole consoleView = (ViewConsole)view;
			consoleView.runOrFight(this); 
		}
		return ;
	}

	public void fleeEnermy() {
		System.out.println("An Algo to go back to the previous position.");
		Scanner choice = new Scanner(System.in);
		int inputChoice = choice.nextInt();
		return ;
	}

	public void fightEnermy() {
		System.out.println("Let's Fight...");
		Scanner choice = new Scanner(System.in);
		int inputChoice = choice.nextInt();
		return ;
	}
}
