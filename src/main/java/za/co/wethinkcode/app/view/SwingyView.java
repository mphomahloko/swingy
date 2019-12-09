package za.co.wethinkcode.app.view;

import java.awt.event.ActionListener;

import za.co.wethinkcode.app.core.GameMap;

/* ************************************************************************** */
/* 				Helps with the View's			      */
/* ************************************************************************** */

public interface SwingyView {
	public void iniView();
	public void gameView();
	public void clearView();
	public void newGameView();
	public void continueView();
	public String getHeroName();
	public String getHeroType();
	public void	alertMsg(String msg);
	public void drawMap(GameMap game);
	public void addPlayersInterraction(ActionListener listensForAction);
}
