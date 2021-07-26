package za.co.wethinkcode.app.view;

import java.awt.event.ActionListener;

import za.co.wethinkcode.app.core.GameMap;

/* ************************************************************************** */
/* 				Helps with the View's			      */
/* ************************************************************************** */

public interface SwingyView {
	void iniView();
	void gameView();
	void clearView();
	void newGameView();
	void continueView();
	String getHeroName();
	String getHeroType();
	void alertMsg(String msg);
	void drawMap(GameMap game);
	void addPlayersInteraction(ActionListener listensForAction);
}
