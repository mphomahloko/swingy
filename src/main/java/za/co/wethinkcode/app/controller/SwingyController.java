package za.co.wethinkcode.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import za.co.wethinkcode.app.core.GameMap;
import za.co.wethinkcode.app.model.SwingyModel;
import za.co.wethinkcode.app.view.SwingyView;

public class SwingyController {
	private SwingyView _theView;
	private SwingyModel _theModel;
	private GameMap _map = new GameMap();;

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
				// _theView.clearView();
				_theView.newGameView();
				_buildHero();
				_map.drawMap();
				consoleGameLoop();
			} else if (inputChoice == 2) {
				// _theView.clearView();
				System.out.println("Correct choice 2");
			} else {
				// _theView.clearView();
				consoleInterraction();
			}
		}catch(Exception e) {
			consoleInterraction();
		}
		return ;
	}

	private void _buildHero() {
		_theModel.createHero(_theView.getHeroName());
		return ;
	}

	private void consoleGameLoop() {
		Scanner choice = new Scanner(System.in);
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
			}catch(Exception e) {
				System.out.println("Something went wrong!.");
			}
		}
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
