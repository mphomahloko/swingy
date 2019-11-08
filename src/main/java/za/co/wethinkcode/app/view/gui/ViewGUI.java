package za.co.wethinkcode.app.view.gui;

import java.awt.event.ActionListener;

import za.co.wethinkcode.app.view.SwingyView;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewGUI extends JFrame implements SwingyView {
    private JPanel _view;
	private JButton _newGame = new JButton("New Game.");
	private JButton _continue = new JButton("Continue...");

	private JLabel _heroName = new JLabel("Hero Name: ");
	private JTextField _getHeroName = new JTextField(10);
	private JButton _createHero = new JButton("Create Hero.");
	
	public ViewGUI() {
		super("Swingy Game.");
		return ;
	}

	@Override
	public void iniView() {
        _view = new JPanel();
		JLabel initLabel = new JLabel("Swingy.");
		_view.add(initLabel);
		_view.add(_newGame);
		_view.add(_continue);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.add(_view);
		this.setVisible(true);
		return ;
	}

	@Override
    public void newGameView() {
		_view = new JPanel();
		_view.add(_heroName);
		_view.add(_getHeroName);
		_view.add(_createHero);

		this.add(_view);
		this.setVisible(true);
		return ;
	}
	
    @Override
	public String getHeroName() {
		return _getHeroName.getText();
	}

	public void addPlayersInterraction(ActionListener listensForAction) {
		_newGame.addActionListener(listensForAction);
		_continue.addActionListener(listensForAction);
		_createHero.addActionListener(listensForAction);
		return ;
	}

	@Override
	public void continueView(){ return ;}

    @Override
	public void clearView() {
		this.remove(_view);
		this.revalidate();
		this.repaint();
		return ;
	}
}
