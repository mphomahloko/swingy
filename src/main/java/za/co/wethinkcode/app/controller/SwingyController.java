package za.co.wethinkcode.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Set;

import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import za.co.wethinkcode.app.core.GameMap;
import za.co.wethinkcode.app.model.SwingyModel;
import za.co.wethinkcode.app.model.Hero;
import za.co.wethinkcode.app.view.SwingyView;
import za.co.wethinkcode.app.view.gui.ViewGUI;
import za.co.wethinkcode.app.core.PlayerStatDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.hibernate.internal.util.collections.CollectionHelper.isEmpty;

public class SwingyController {
	private SwingyView _theView;
	private SwingyModel _theModel;
	private GameMap _map;

	public SwingyController(SwingyModel theModel, SwingyView theView) {
		_theView = theView;
		_theModel = theModel;

		return ;
	}
	
	public void guiInterraction() {
		_theView.iniView();
		_theView.addPlayersInterraction(new SwingyListner());
		return ;
	}

	public void consoleInterraction() {
		_theView.iniView();
		Scanner choice = new Scanner(System.in);
		
		try{
			int inputChoice = choice.nextInt();
			if (inputChoice == 1) {
				_theView.clearView();
				_theView.newGameView();
				_buildHero();
				_theView.drawMap(_map.map);
				consoleGameLoop();
			} else if (inputChoice == 2) {
				_theView.clearView();
				continueOnConsole();
			} else {
				_theView.clearView();
				consoleInterraction();
			}
		}catch(Exception e) {
			consoleInterraction();
		}
		return ;
	}

	private void continueOnConsole() {
		_theView.continueView();
		Scanner choice = new Scanner(System.in);
		
		try {
			PlayerStatDB db = PlayerStatDB.getPlayerStats();
			List<Map<String, String>> stats = db.getUsers();
			if (stats.size() == 0) {
				_theView.clearView();
				System.out.println("No Hero's Exist yet CREATE A HERO FIRST");
				consoleInterraction();
			}
			for (Map<String,String> m:stats) {
				System.out.println(m.get("id") + ". " + m.get("name"));
			}
			System.out.println("Choose your player");
			int inputChoice = choice.nextInt();
			for (Map<String,String> m:stats) {
				if (Integer.parseInt(m.get("id")) == inputChoice) {
					_map = new GameMap(_theModel.createCustomHero(m), _theView);
				}
			}
			_theView.drawMap(_map.map);
			consoleGameLoop();

		}catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
		}
		return ;
	}

	private void _buildHero() {
		PlayerStatDB db = PlayerStatDB.getPlayerStats();
		System.out.print(_theView.getHeroType());
		Hero hero = _theModel.createHero(_theView.getHeroName(), _theView.getHeroType());
        try {
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = (Validator) factory.getValidator();
			Set<ConstraintViolation<Hero>> constraintViolations = validator.validate(hero);
		if (!isEmpty(constraintViolations))
		{
				System.out.printf( "%s %s\n", constraintViolations.iterator().next().getConstraintDescriptor(),
						constraintViolations.iterator().next().getMessage());
				return ;
		}
            db.insertInfo(hero);
            ResultSet res = db.getGeneratedKeys();
            while(res.next()) {
               hero.setHeroId(Integer.parseInt(res.getString("LAST")));
            }
			_map = new GameMap(hero, _theView);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

		return ;
	}

	private void consoleGameLoop() {
		Scanner choice = new Scanner(System.in);
		PlayerStatDB db = PlayerStatDB.getPlayerStats();

		while (true) {
			System.out.println("1.move up\n2.move down\n3.move left\n4.move right");
			try{
				int inputChoice = choice.nextInt();
				if (inputChoice == 1) {
					_map.moveUp();
				} else if (inputChoice == 2) {
					_map.moveDown();
				}else if (inputChoice == 3) {
					_map.moveLeft();
				}else if (inputChoice == 4) {
					_map.moveRight();
				}
				 else {
					 System.out.println("Read the following instructions properly!.");
				}
            	db.updateInfo(_map.hero);
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
				System.out.println("You win.");
				break ;
			}
		}
		return ;
	}

	class SwingyListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("New Game.")) {
				_theView.clearView();
				_theView.newGameView();
			}
			if (e.getActionCommand().equals("Continue")) {
				_theView.clearView();
				ViewGUI v = (ViewGUI)_theView;
				try {
					PlayerStatDB db = PlayerStatDB.getPlayerStats();
					List<Map<String, String>> stats = db.getUsers();
					for (Map<String,String> m:stats) {
						if (Integer.parseInt(m.get("id")) == v.selectedHero()) {
							_map = new GameMap(_theModel.createCustomHero(m), _theView);
						}
					}
				}catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				_theView.gameView();
				_theView.drawMap(_map.map);
			}
			if (e.getActionCommand().equals("Create Hero.")) {
				_buildHero();
				_theView.clearView();
				_theView.gameView();
				_theView.drawMap(_map.map);
			}
			if (e.getActionCommand().equals("Continue ...")) {
				_theView.clearView();
				try {
					PlayerStatDB db = PlayerStatDB.getPlayerStats();
					List<Map<String, String>> stats = db.getUsers();
					if (stats.size() == 0) {
						_theView.newGameView();
						return ;
					}
				}catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				_theView.continueView();
			}
			if (e.getActionCommand().equals("UP")) {
				_map.moveUp();
				try {
					PlayerStatDB db = PlayerStatDB.getPlayerStats();
					db.updateInfo(_map.hero);
				}catch (ClassNotFoundException e1) {
						e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (e.getActionCommand().equals("DOWN")) {
				_map.moveDown();
				try {
					PlayerStatDB db = PlayerStatDB.getPlayerStats();
					db.updateInfo(_map.hero);
				}catch (ClassNotFoundException e1) {
						e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (e.getActionCommand().equals("LEFT")) {
				_map.moveLeft();
				try {
					PlayerStatDB db = PlayerStatDB.getPlayerStats();
					db.updateInfo(_map.hero);
				}catch (ClassNotFoundException e1) {
						e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (e.getActionCommand().equals("RIGHT")) {
				_map.moveRight();
				try {
					PlayerStatDB db = PlayerStatDB.getPlayerStats();
					db.updateInfo(_map.hero);
				}catch (ClassNotFoundException e1) {
						e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return ;
		}
	}
}
