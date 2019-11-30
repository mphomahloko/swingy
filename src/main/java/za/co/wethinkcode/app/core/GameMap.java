package za.co.wethinkcode.app.core;

import za.co.wethinkcode.app.model.Hero;
import za.co.wethinkcode.app.view.SwingyView;

public class GameMap {
	public String [][] map;
	public SwingyView view;
	public Hero hero;

	public GameMap(Hero hero, SwingyView view) {
		this.hero = hero;
		//rough sketch
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
		placePlayer();
		return ;
	}

	// Algorithm to fight I guess
	public void placePlayer() {
		if (this.map.length <= hero.getHeroY() || this.map[0].length <= hero.getHeroX()
			|| hero.getHeroY() < 0 || hero.getHeroX() < 0)
		{
			// implement an alert for each view
			view.alertMsg("You Win");
			hero.setHeroX(20 / 2);
			hero.setHeroY(20 / 2);
			placePlayer();
			view.clearView();
			view.iniView();
		} else {
			this.map[hero.getHeroY()][hero.getHeroX()] = "P";
		}
		return ;
	}

	public void moveRight() {
		hero.setHeroX(hero.getHeroX() + 1);
		_renderMap();
		view.drawMap(map);
		return ;
	}

	public void moveLeft() {
		hero.setHeroX(hero.getHeroX() - 1);
		_renderMap();
		view.drawMap(map);
		return ;
	}

	public void moveDown() {
		hero.setHeroY(hero.getHeroY() + 1);
		_renderMap();
		view.drawMap(map);
		return ;
	}

	public void moveUp() {
		hero.setHeroY(hero.getHeroY() - 1);
		_renderMap();
		view.drawMap(map);
		return ;
	}
}
