package za.co.wethinkcode.app.core;

import java.util.Random;

import za.co.wethinkcode.app.model.Hero;
import za.co.wethinkcode.app.view.SwingyView;
import za.co.wethinkcode.app.view.console.ViewConsole;
import za.co.wethinkcode.app.view.gui.ViewGUI;

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
		this.map = new String[20][44];
		this.view = view;
		renderMap();
		return;
	}

	public void renderMap() {
		for (int i = 0; i < this.map.length; i += 1) {
			for (int j = 0; j < this.map[0].length; j += 1) {
				this.map[i][j] = ".";
			}
		}
		// this is a problem
		this.map[6][10] = "E";
		placePlayer();
		return;
	}

	public void placePlayer() {
		int level = hero.getHeroLevel() + 1;
		int requiredExperiece = level * 1000 + (level - 1) * (level -1) * 450;
		int experience =  hero.getHeroExperience();
		if (this.map.length <= hero.getHeroY() || this.map[0].length <= hero.getHeroX() || hero.getHeroY() < 0
				|| hero.getHeroX() < 0) {
			hero.setHeroX(44 / 2);
			hero.setHeroY(20 / 2);
			view.alertMsg("YOU WIN LEVELING YOU UP IF NECESSARY!!!");
			if ( requiredExperiece < experience) {
				hero.setHeroLevel(hero.getHeroLevel()+1);
			}
			if (view instanceof ViewConsole) {
				view.clearView();
			}
		}
		if (this.map[hero.getHeroY()][hero.getHeroX()] == "E") {
			view.alertMsg("You have Encounterd an enermy");
			_fightOrRunSimulation();
		}

		this.map[hero.getHeroY()][hero.getHeroX()] = "P";

		if (level > 7) {
			if (view instanceof ViewConsole) {
				view.clearView();
				view.alertMsg("You Win");
				return;
			}
			view.alertMsg("You Win");
			view.clearView();
			view.iniView();
			return;
		}
		return;
	}

	public void moveRight() {
		previousPos[0] = hero.getHeroX();
		previousPos[1] = hero.getHeroY();
		hero.setHeroX(hero.getHeroX() + 1);
		renderMap();
		view.drawMap(this);
		return;
	}

	public void moveLeft() {
		previousPos[0] = hero.getHeroX();
		previousPos[1] = hero.getHeroY();
		hero.setHeroX(hero.getHeroX() - 1);
		renderMap();
		view.drawMap(this);
		return;
	}

	public void moveDown() {
		previousPos[0] = hero.getHeroX();
		previousPos[1] = hero.getHeroY();
		hero.setHeroY(hero.getHeroY() + 1);
		renderMap();
		view.drawMap(this);
		return;
	}

	public void moveUp() {
		previousPos[0] = hero.getHeroX();
		previousPos[1] = hero.getHeroY();
		hero.setHeroY(hero.getHeroY() - 1);
		renderMap();
		view.drawMap(this);
		return;
	}

	private void _fightOrRunSimulation() {
		if (view instanceof ViewConsole) {
			ViewConsole consoleView = (ViewConsole) view;
			consoleView.runOrFight(this);
			return;
		}
		ViewGUI guiView = (ViewGUI) view;
		guiView.clearView();
		guiView.fightgameView(this);
		return;
	}

	public void fleeEnermy() {
		hero.setHeroX(previousPos[0]);
		hero.setHeroY(previousPos[1]);
		renderMap();
		return;
	}

	public void fightEnermy() {
		// add the experience field to complete this section
		Random r = new Random();
		int s = r.nextInt(2);
		if (s == 0) {
			gameState = false;
			if (view instanceof ViewConsole) {
				view.clearView();
				view.alertMsg("You lost the fight.");
				return;
			}
			view.alertMsg("You lost the fight.");
			view.clearView();
			view.iniView();
			return;
		}
		hero.setHeroExperience(hero.getHeroExperience()+24);
		System.out.println("Let's Fight..." + s);
		return;
	}
}
