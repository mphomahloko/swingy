package za.co.wethinkcode.app.view;

import java.awt.event.ActionListener;

	/* ************************************************************************** */
	/* 							Helps with the View's							  */
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
	public void drawMap(String [][] map);
	public void addPlayersInterraction(ActionListener listensForAction);
}
