package za.co.wethinkcode.app.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingyView extends JFrame {
	private JPanel _view;
	private JButton _newGame = new JButton("New Game.");
	private JButton _continue = new JButton("Continue...");

	private JLabel _heroName = new JLabel("Hero Name: ");
	private JTextField _getHeroName = new JTextField(10);
	private JButton _createHero = new JButton("Create Hero.");
	
	public SwingyView() {
		super("Swingy Game.");
	}
	
	public void initGUIView() {
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
	
	public void initGUIViewClear() {
		this.remove(_view);
		this.revalidate();
		this.repaint();
	}

	public void newGameGUI() {
		_view = new JPanel();
		_view.add(_heroName);
		_view.add(_getHeroName);
		_view.add(_createHero);

		this.add(_view);
		this.setVisible(true);
		return ;
	}

	public String heroName() {
		return _getHeroName.getText();
	}

	public void addPlayersInterraction(ActionListener listensForAction) {
		_newGame.addActionListener(listensForAction);
		_continue.addActionListener(listensForAction);
		_createHero.addActionListener(listensForAction);
		return ;
	}
}
