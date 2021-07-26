package za.co.wethinkcode.app.model;

import java.util.Map;

public class SwingyModel {
	public SwingyModel() {}

	private HeroBuilder _createHeroType(String type) {
        	HeroBuilder hBuilder = null;
        	if (type.equals("Witch")) {
            		hBuilder = new Witch();
        	}
        	if (type.equals("Goblin")) {
            		hBuilder = new Goblin();
        	}
        	if (type.equals("Giant")) {
            		hBuilder = new Giant();
        	}
        	return hBuilder;
	}
    
	public Hero createHero(String hName, String type) {
        	HeroBuilder hBuilder = _createHeroType(type);
        	HeroEngineer hEngineer = new HeroEngineer(hBuilder);
		
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
