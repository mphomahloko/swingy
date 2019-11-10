package za.co.wethinkcode.app.model;

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

        return hEngineer.getHero();
	}

    public Hero createCustomHero(Map<String,String> heroDets) {
		HeroBuilder customHero = new CustomHero();
        HeroEngineer hEngineer = new HeroEngineer(customHero);

        hEngineer.makeCustomHero(heroDets);

        return hEngineer.getHero();
    }
}
