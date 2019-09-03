package za.co.wethinkcode.app.controller;

import za.co.wethinkcode.app.controller.GameController;
import za.co.wethinkcode.app.view.gui.GUIView;

public class GUIController extends GameController {
	private GUIView _gui;
	public GUIController() {
        super();
        System.out.println("GUI controller running");
        this._gui = new GUIView();
    }   
}
