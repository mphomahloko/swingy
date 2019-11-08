package za.co.wethinkcode.app.core;

import za.co.wethinkcode.app.model.Hero;

public class GameMap {
	private String [][] _map;
	public Hero hero;

	public GameMap(Hero hero) {
		//rough sketch
		this.hero = hero;
		this.hero.setHeroX(39 / 2);
		this.hero.setHeroY(39 / 2);
		this._map = new String[39][39];
		_renderMap();
		return ;
	}
	
	private void _renderMap() {
		for (int i = 0; i < this._map.length; i += 1) {
			for (int j = 0; j < this._map.length; j += 1) {
				this._map[i][j] = ".";
			}
		}
		placePlayer();
		return ;
	}

	public void placePlayer() {
		this._map[hero.getHeroY()][hero.getHeroX()] = "P";
		return ;
	}

	public void moveRight() {
		hero.setHeroX(hero.getHeroX() + 1);
		_renderMap();
		drawMap();
		return ;
	}

	public void moveLeft() {
		hero.setHeroX(hero.getHeroX() - 1);
		_renderMap();
		drawMap();
		return ;
	}

	public void moveDown() {
		hero.setHeroY(hero.getHeroY() + 1);
		_renderMap();
		drawMap();
		return ;
	}

	public void moveUp() {
		hero.setHeroY(hero.getHeroY() - 1);
		_renderMap();
		drawMap();
		return ;
	}

	// place in view
	public void drawMap() {
		for (int i = 0; i < this._map.length; i += 1) {
			for (int j = 0; j < this._map.length; j += 1) {
				System.out.print(this._map[i][j]);
			}
			System.out.println();
		}
		return ;
	}
}
