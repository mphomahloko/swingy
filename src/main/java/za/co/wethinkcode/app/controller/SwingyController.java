package za.co.wethinkcode.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import za.co.wethinkcode.app.model.SwingyModel;
import za.co.wethinkcode.app.view.SwingyView;

public class SwingyController {
	private SwingyView _theView;
	private SwingyModel _theModel;

	public SwingyController(SwingyView theView, SwingyModel theModel) {
		_theView = theView;
		_theModel = theModel;

		_theView.addPlayersInterraction(new SwingyListner());

		return ;
	}

	class SwingyListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("A field in the view was modified.");
			return ;
		}
	}
}
