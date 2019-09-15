package za.co.wethinkcode.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import za.co.wethinkcode.app.model.SwingyModel;
import za.co.wethinkcode.app.view.SwingyView;
import za.co.wethinkcode.app.view.gui.ViewGUI;
import za.co.wethinkcode.app.view.console.ViewConsole;

public class SwingyController {
	private SwingyView _theView;
	private SwingyModel _theModel;

	public SwingyController(SwingyModel theModel, SwingyView theView) {
		_theView = theView;
		_theModel = theModel;

		return ;
	}
	
	public void guiInterraction() {
		_theView.addPlayersInterraction(new SwingyListner());
		return ;
	}

	public void consoleInterraction() {
		Scanner choice = new Scanner(System.in);
		int inputChoice = choice.nextInt();
		System.out.println(inputChoice);
		if (inputChoice == 1) {
			_theView.clearView();
			System.out.println("Correct choice 1");
		} else if (inputChoice == 2) {
			_theView.clearView();
			System.out.println("Correct choice 2");
		} else {
			_theView.clearView();
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
