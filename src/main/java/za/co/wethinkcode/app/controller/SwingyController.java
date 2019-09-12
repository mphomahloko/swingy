package za.co.wethinkcode.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		_theView.initGUIView();
		_theView.addPlayersInterraction(new SwingyListner());
		return ;
	}

	private void _createHero() {
		_theView.newGameGUI();
	}

	public void consoleInterraction() {
		return ;
	}

	class SwingyListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("New Game.")) {
				_theView.initGUIViewClear();
				_createHero();
			}
			if (e.getActionCommand().equals("Create Hero.")) {
				_theView.heroName();
			}
			System.out.println(e.getActionCommand());
			return ;
		}
	}
}
