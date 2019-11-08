package za.co.wethinkcode.app.model;

import java.sql.SQLException;
import java.sql.ResultSet;

import za.co.wethinkcode.app.core.PlayerStatDB;

public class SwingyModel {
	public SwingyModel() {
        return ;
    }

    // turn this into a factory
	public Hero createHero(String hName){
		HeroBuilder oBuilder = new OldHeroBuilder();
        HeroEngineer hEngineer = new HeroEngineer(oBuilder);
		
        hEngineer.makeHero(hName);

        Hero hero = hEngineer.getHero();
        PlayerStatDB db = PlayerStatDB.getPlayerStats();

        try {
            db.insertInfo(hero);
            ResultSet res = db.getGeneratedKeys();
            while(res.next()) {
               hero.setHeroId(Integer.parseInt(res.getString("LAST")));
            }
            System.out.println(hero.toString());
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return hero;
	}
}
