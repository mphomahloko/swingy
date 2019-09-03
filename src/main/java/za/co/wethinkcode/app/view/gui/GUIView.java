package za.co.wethinkcode.app.view.gui;

import javax.swing.JFrame;

public class GUIView extends JFrame{
	public GUIView() {
		JFrame frame = new JFrame("Swingy");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(1100, 800);
		frame.setLayout(null);
		frame.setVisible(true);
		return ;
	}
}
