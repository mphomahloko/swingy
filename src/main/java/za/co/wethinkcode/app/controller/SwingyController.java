package za.co.wethinkcode.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import za.co.wethinkcode.app.model.SwingyModel;
import za.co.wethinkcode.app.view.SwingyView;

public class SwingyController {
	private SwingyView _theView;
	private SwingyModel _theModel;

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
