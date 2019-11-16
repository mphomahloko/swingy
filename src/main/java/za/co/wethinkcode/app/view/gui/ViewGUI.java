package za.co.wethinkcode.app.view.gui;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import za.co.wethinkcode.app.core.PlayerStatDB;
import za.co.wethinkcode.app.view.SwingyView;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ViewGUI extends JFrame implements SwingyView {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel _view;
	private JButton _btnUp = new JButton("UP");
	private JButton _btnDown = new JButton("DOWN");
	private JButton _btnLeft = new JButton("LEFT");
	private JButton _btnRight = new JButton("RIGHT");
	private JButton _newGame = new JButton("New Game.");
	private JButton _continue = new JButton("Continue ...");
	private JButton _cont = new JButton("Continue");

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
		_view.add(_heroType);
		_view.add(cbHero);
		_view.add(_createHero);

		this.add(_view);
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
		return ;
	}

	private Object makeObj(final String item)  {
		return new Object() { public String toString() { return item; } };
	}

	@Override
	public void continueView() {
		_view = new JPanel();
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
		_view.add(_cont);
		_view.add(Heros);
		this.add(_view);
		this.setVisible(true);
		return ;
	}

	@Override
	public void gameView() {
		_view = new JPanel();
		_view.setLayout(null);
		_view.add(_txtDisplay);
		_txtDisplay.setEditable(false);
		_txtDisplay.setBounds(50, 50, 320, 350);
		_view.add(_txtPlayerStats);
		_txtPlayerStats.setEditable(false);
		_txtPlayerStats.setBounds(400, 50, 150, 150);
		_view.add(_btnUp);
		_btnUp.setBounds(50, 500, 100,30);
		_view.add(_btnDown);
		_btnDown.setBounds(150, 500, 100, 30);
		_view.add(_btnLeft);
		_btnLeft.setBounds(250, 500, 100, 30);
		_view.add(_btnRight);
		_btnRight.setBounds(350, 500, 100, 30);

		this.add(_view);
		this.setVisible(true);
		return ;
	}

	@Override
    public void drawMap(String [][] map) {
		_txtDisplay.setText("\n");
		for (int i = 0; i < map.length; i += 1) {
			_txtDisplay.append("\t");
			for (int j = 0; j < map.length; j += 1) {
				_txtDisplay.append(String.valueOf(map[i][j]) + " ");
			}
			_txtDisplay.append("\n\r");
		}
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
