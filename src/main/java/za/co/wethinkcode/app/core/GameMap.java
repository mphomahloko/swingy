package za.co.wethinkcode.app.core;

public class GameMap {
	private String [][] _map;
	private int _heroX, _heroY;

	public GameMap() {
		//rough sketch

		this._heroX = 39 / 2;
		this._heroY = 39 / 2;
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
		this._map[_heroY][_heroX] = "P";
		return ;
	}

	public void moveRight() {
		this._heroX += 1;
		_renderMap();
		drawMap();
		return ;
	}

	public void moveLeft() {
		this._heroX -= 1;
		_renderMap();
		drawMap();
		return ;
	}

	public void moveDown() {
		this._heroY += 1;
		_renderMap();
		drawMap();
		return ;
	}

	public void moveUp() {
		this._heroY -= 1;
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
