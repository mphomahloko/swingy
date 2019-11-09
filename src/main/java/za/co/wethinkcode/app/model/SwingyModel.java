package za.co.wethinkcode.app.model;

import java.sql.SQLException;
import java.sql.ResultSet;

import za.co.wethinkcode.app.core.PlayerStatDB;

import java.util.Map;

public class SwingyModel {
	public SwingyModel() {
        return ;
    }

    // turn this into a factory
    private HeroBuilder _createHeroType(String type) {
        HeroBuilder oBuilder;
        if (type == "Witch") {
            oBuilder = new OldHeroBuilder();
        }
        else {
            oBuilder = new OldHeroBuilder();
        }
        return oBuilder;
    }
    
	public Hero createHero(String hName, String type) {
        HeroBuilder oBuilder = _createHeroType(type);
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

    public Hero createCustomHero(Map<String,String> heroDets) {
		HeroBuilder customHero = new CustomHero();
        HeroEngineer hEngineer = new HeroEngineer(customHero);

        hEngineer.makeCustomHero(heroDets);

        return hEngineer.getHero();
    }
}
