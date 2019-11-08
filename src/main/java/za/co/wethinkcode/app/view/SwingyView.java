package za.co.wethinkcode.app.view;

import java.awt.event.ActionListener;


	/* ************************************************************************** */
	/* 							Helps with the View's							  */
	/* ************************************************************************** */

public interface SwingyView {
	public void iniView();
	public void newGameView();
	public String getHeroName();
	public void clearView();
	public void continueView();
	public void addPlayersInterraction(ActionListener listensForAction);
}
