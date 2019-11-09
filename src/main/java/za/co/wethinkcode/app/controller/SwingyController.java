package za.co.wethinkcode.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import za.co.wethinkcode.app.core.GameMap;
import za.co.wethinkcode.app.model.SwingyModel;
import za.co.wethinkcode.app.view.SwingyView;
import za.co.wethinkcode.app.core.PlayerStatDB;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SwingyController {
	private SwingyView _theView;
	private SwingyModel _theModel;
	private GameMap _map;

	public SwingyController(SwingyModel theModel, SwingyView theView) {
		_theView = theView;
		_theModel = theModel;

		return ;
	}
	
	public void guiInterraction() {
		_theView.iniView();
		_theView.addPlayersInterraction(new SwingyListner());
		return ;
	}

	public void consoleInterraction() {
		_theView.iniView();
		Scanner choice = new Scanner(System.in);
		
		try{
			int inputChoice = choice.nextInt();
			if (inputChoice == 1) {
				_theView.clearView();
				_theView.newGameView();
				_buildHero();
				_map.drawMap();
				consoleGameLoop();
			} else if (inputChoice == 2) {
				_theView.clearView();
				continueOnConsole();
			} else {
				_theView.clearView();
				consoleInterraction();
			}
		}catch(Exception e) {
			consoleInterraction();
		}
		// choice.close();
		return ;
	}

	private void continueOnConsole() {
		_theView.continueView();
		Scanner choice = new Scanner(System.in);
		try {
			PlayerStatDB db = PlayerStatDB.getPlayerStats();
			List<Map<String, String>> stats = db.getUsers();
			for (Map<String,String> m:stats) {
				System.out.println(m.get("id") + ". " + m.get("name"));
			}
			int inputChoice = choice.nextInt();
			for (Map<String,String> m:stats) {
				if (Integer.parseInt(m.get("id")) == inputChoice) {
					_map = new GameMap(_theModel.createCustomHero(m));
				}
			}

			_map.drawMap();
			consoleGameLoop();

		}catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
		}
		// choice.close();
		return ;
	}

	private void _buildHero() {
		_map = new GameMap(_theModel.createHero(_theView.getHeroName(), _theView.getHeroType()));
		return ;
	}

	private void consoleGameLoop() {
		Scanner choice = new Scanner(System.in);
		PlayerStatDB db = PlayerStatDB.getPlayerStats();

		while (true) {
			System.out.println("1.move up\n2.move down\n3.move left\n4.move right");
			try{
				int inputChoice = choice.nextInt();
				if (inputChoice == 1) {
					_map.moveUp();
				} else if (inputChoice == 2) {
					_map.moveDown();
				}else if (inputChoice == 3) {
					_map.moveLeft();
				}else if (inputChoice == 4) {
					_map.moveRight();
				}
				 else {
					 System.out.println("Read the following instructions properly!.");
				}
            	db.updateInfo(_map.hero);
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
				System.out.println("Something went wrong!?.");
				break ;
			}
		}
		// choice.close();
		return ;
	}

	class SwingyListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("New Game.")) {
				_theView.clearView();
				_theView.newGameView();
			}
			if (e.getActionCommand().equals("Create Hero.")) {
				_buildHero();
			}
			return ;
		}
	}
}
