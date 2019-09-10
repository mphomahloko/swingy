package za.co.wethinkcode.app.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingyView extends JFrame {
	private JPanel _initView = new JPanel();
	private JButton _newGame = new JButton("New Game.");
	private JButton _continue = new JButton("Continue...");
	
	public SwingyView() {
		super("Swingy Game.");
	}
	
	public void initGUIView() {
		JLabel initLabel = new JLabel("Swingy.");
		_initView.add(initLabel);
		_initView.add(_newGame);
		_initView.add(_continue);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.add(_initView);
		return ;
	}
	
	public void initGUIViewClear() {
		this.remove(_initView);
		this.revalidate();
		this.repaint();
	}

	public void addPlayersInterraction(ActionListener listensForAction) {
		_newGame.addActionListener(listensForAction);
		_continue.addActionListener(listensForAction);
		return ;
	}
}