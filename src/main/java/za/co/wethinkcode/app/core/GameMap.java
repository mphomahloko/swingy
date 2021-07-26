package za.co.wethinkcode.app.core;

import java.util.Random;

import za.co.wethinkcode.app.model.Hero;
import za.co.wethinkcode.app.view.SwingyView;
import za.co.wethinkcode.app.view.console.ViewConsole;
import za.co.wethinkcode.app.view.gui.ViewGUI;
import za.co.wethinkcode.app.artifacts.Artifacts;

public class GameMap {
	public String[][] map;
	public SwingyView view;
	public Hero hero;
	public static int _mapSize = 9;
	private final Integer[] previousPos;
	public boolean gameState;

	public GameMap(Hero hero, SwingyView view) {
		this.hero = hero;
		int level = hero.getHeroLevel();
		 _mapSize = (level-1)*5+10-(level%2);
		previousPos = new Integer[2];
		previousPos[0] = hero.getHeroX();
		previousPos[1] = hero.getHeroY();

		this.map = new String[_mapSize][_mapSize];
		this.view = view;
		renderMap();
		placePlayer();
	}

	public void renderMap() {
		for (int i = 0; i < this.map.length; i += 1) {
			for (int j = 0; j < this.map[0].length; j += 1) {
				this.map[i][j] = ".";
			}
		}
		// this was moved
		this.map[6][6] = "E";
	}

	public void placePlayer() {
		int level = hero.getHeroLevel() + 1;
		int requiredExperiece = level * 1000 + (level - 1) * (level -1) * 450;
		int experience =  hero.getHeroExperience();
		if (this.map.length <= hero.getHeroY() || this.map[0].length <= hero.getHeroX() || hero.getHeroY() < 0
				|| hero.getHeroX() < 0) {
			hero.setHeroX(_mapSize / 2);
			hero.setHeroY(_mapSize / 2);
			view.alertMsg("YOU WIN LEVELING YOU UP IF NECESSARY!!!");
			if (requiredExperiece <= experience) {
				_mapSize = (level-1)*5+10-(level%2);
				hero.setHeroX(_mapSize / 2);
				hero.setHeroY(_mapSize / 2);
				hero.setHeroLevel(hero.getHeroLevel()+1);
				this.map = new String[_mapSize][_mapSize];
				renderMap();
				placePlayer();
			}
			if (view instanceof ViewConsole) {
				view.clearView();
			}
		}
		if (this.map[hero.getHeroY()][hero.getHeroX()].equals("E")) {
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
		}
	}

	public void moveRight() {
		previousPos[0] = hero.getHeroX();
		previousPos[1] = hero.getHeroY();
		hero.setHeroX(hero.getHeroX() + 1);
		renderMap();
		placePlayer();
		view.drawMap(this);
	}

	public void moveLeft() {
		previousPos[0] = hero.getHeroX();
		previousPos[1] = hero.getHeroY();
		hero.setHeroX(hero.getHeroX() - 1);
		renderMap();
		placePlayer();
		view.drawMap(this);
	}

	public void moveDown() {
		previousPos[0] = hero.getHeroX();
		previousPos[1] = hero.getHeroY();
		hero.setHeroY(hero.getHeroY() + 1);
		renderMap();
		placePlayer();
		view.drawMap(this);
	}

	public void moveUp() {
		previousPos[0] = hero.getHeroX();
		previousPos[1] = hero.getHeroY();
		hero.setHeroY(hero.getHeroY() - 1);
		renderMap();
		placePlayer();
		view.drawMap(this);
	}

	private void _fightOrRunSimulation() {
		if (view instanceof ViewConsole) {
			ViewConsole consoleView = (ViewConsole) view;
			consoleView.runOrFight(this);
			return;
		}
		ViewGUI guiView = (ViewGUI) view;
		guiView.clearView();
		guiView.fightGameView(this);
	}

	public void fleeEnemy() {
		hero.setHeroX(previousPos[0]);
		hero.setHeroY(previousPos[1]);
		renderMap();
	}

	public void fightEnemy() {
		Random r = new Random();
		int s = r.nextInt(3);
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
		hero.setHeroExperience(hero.getHeroExperience() + 1450);
		new Artifacts(hero);
	}
}
