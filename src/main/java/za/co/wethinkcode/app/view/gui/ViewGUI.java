package za.co.wethinkcode.app.view.gui;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import za.co.wethinkcode.app.core.PlayerStatDB;
import za.co.wethinkcode.app.view.SwingyView;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.GridLayout;

public class ViewGUI extends JFrame implements SwingyView {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel _view, _PanelA, _PanelB;

	private JButton _btnUp = new JButton("UP");
	private JButton _btnDown = new JButton("DOWN");
	private JButton _btnLeft = new JButton("LEFT");
	private JButton _btnRight = new JButton("RIGHT");
	private JButton _newGame = new JButton("New Game.");
	private JButton _continue = new JButton("Continue ...");
	private JButton _cont = new JButton("Continue");
	private JButton _Run = new JButton("Run");
	private JButton _Fight = new JButton("Fight");
	private JButton _Quit = new JButton("Quit");
	private JButton _back = new JButton("Back");


	private JLabel _heroName = new JLabel("Hero Name: ");
	private JTextField _getHeroName = new JTextField(10);
	private JLabel _heroType = new JLabel("Hero Type: ");
	private JButton _createHero = new JButton("Create Hero.");
	private String[] hero  = {"Swordman", "Knight", "hunter"};
	private JComboBox cbHero = new JComboBox<String>(hero);
	private  JComboBox Heros = new JComboBox<String>();
	private JTextArea _txtDisplay = new JTextArea(100, 100);
	private JTextArea _txtPlayerStats = new JTextArea(50, 50);
	
	public ViewGUI() {
		super("Swingy Game.");
		return ;
	}

	@Override
	public void iniView() {
		_view = new JPanel();
		_view.setLayout(new GridLayout(3, 1));
		_view.add(_newGame);
		_view.add(_continue);
		_view.add(_Quit);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(200, 200);
		this.setLocationRelativeTo(null);
		this.add(_view);
		this.setVisible(true);
		return ;
	}

	@Override
    public void newGameView() {
		_view = new JPanel();
		_view.setLayout(null);

		_view.add(_heroName);
		_heroName.setBounds(10, 20, 100, 30);

		_view.add(_getHeroName);
		_getHeroName.setBounds(100, 20, 200, 30);

		_view.add(_heroType);
		_heroType.setBounds(10, 50, 100, 30);

		_view.add(cbHero);
		cbHero.setBounds(100, 50, 200, 30);

		_view.add(_createHero);
		_createHero.setBounds(100, 100, 120, 30);

		_view.add(_back);
		_back.setBounds(210, 100, 90, 30);

		this.add(_view);
		this.setSize(320, 170);
		this.setVisible(true);
		return ;
	}

    @Override
	public String getHeroName() {
		return _getHeroName.getText();
	}

    @Override
	public String getHeroType() {
		return hero[cbHero.getSelectedIndex()];
	}

	public int selectedHero(){
		return Heros.getSelectedIndex() + 1;
	}

	@Override
	public void addPlayersInterraction(ActionListener listensForAction) {
		_newGame.addActionListener(listensForAction);
		_continue.addActionListener(listensForAction);
		_createHero.addActionListener(listensForAction);
		_btnUp.addActionListener(listensForAction);
		_btnDown.addActionListener(listensForAction);
		_btnLeft.addActionListener(listensForAction);
		_btnRight.addActionListener(listensForAction);
		_cont.addActionListener(listensForAction);
		_back.addActionListener(listensForAction);
		return ;
	}

	private Object makeObj(final String item)  {
		return new Object() { public String toString() { return item; } };
	}

	@Override
	public void continueView() {
		try {
			PlayerStatDB db = PlayerStatDB.getPlayerStats();
			List<Map<String, String>> stats = db.getUsers();
			for (Map<String,String> m:stats) {
				Heros.addItem(makeObj(m.get("name")));
			}
			
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch(Exception e1) {
			e1.printStackTrace();
		}

		_view = new JPanel();
		_view.setLayout(null);
		
		JLabel conViewtLabel = new JLabel("Select a Hero: ");
		_view.add(conViewtLabel);
		conViewtLabel.setBounds(10, 20, 100, 20);

		_view.add(Heros);
		Heros.setBounds(95, 17, 200, 30);

		_view.add(_cont);
		_cont.setBounds(105, 85, 100, 30);

		_view.add(_back);
		_back.setBounds(195, 85, 100, 30);

		this.add(_view);
		this.setSize(300, 150);
		this.setVisible(true);
		return ;
	}

	@Override
	public void gameView() {

		_view = new JPanel();
		_view.setLayout(null);

		_PanelA = new JPanel();
		_PanelA.setLayout(null);
		_PanelA.add(_txtDisplay);
		_txtDisplay.setBounds(10, 20, 290, 350);
		_txtDisplay.setEditable(false);
		_PanelA.setBounds(50, 30, 320, 380);
		_PanelA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		_PanelA.setBorder(BorderFactory.createTitledBorder("Game Display"));
		_view.add(_PanelA);


		_PanelB = new JPanel();
		_PanelB.setLayout(null);
		_PanelB.add(_txtPlayerStats);
		_txtPlayerStats.setBounds(10, 20, 140, 140);
		_PanelB.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		_PanelB.setBorder(BorderFactory.createTitledBorder("Player Stats"));
		_txtPlayerStats.setEditable(false);
		_PanelB.setBounds(400, 30, 160, 170);
		_view.add(_PanelB);
		
		
		
		
		_view.add(_btnUp);
		_btnUp.setBounds(450, 270, 70,30);

		_view.add(_btnDown);
		_btnDown.setBounds(450, 300, 70, 30);

		_view.add(_btnLeft);
		_btnLeft.setBounds(390, 300, 70, 30);

		_view.add(_btnRight);
		_btnRight.setBounds(510, 300, 70, 30);

		_view.add(_Run);
		_Run.setBounds(390, 250, 70, 30);
		_Run.setEnabled(false);

		_view.add(_Fight);
		_Fight.setBounds(510, 250, 70, 30);
		_Fight.setEnabled(false);
		
		_view.add(_back);
		_back.setBounds(490, 390, 100, 30);


		this.add(_view);
		this.setSize(600, 450);
		this.setVisible(true);
		return ;
	}

	@Override
    public void drawMap(String [][] map) {
		_txtDisplay.setText("\n");
		for (int i = 0; i < map.length; i += 1) {
			_txtDisplay.append("     ");
			for (int j = 0; j < map.length; j += 1) {
				_txtDisplay.append(String.valueOf(map[i][j]) + " ");
			}
			_txtDisplay.append("\n\r");
		}
		// add palyer stats
		return ;
	}

	@Override
	public void alertMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
		return ;
	}

    @Override
	public void clearView() {
		this.remove(_view);
		this.revalidate();
		this.repaint();
		return ;
	}

}
