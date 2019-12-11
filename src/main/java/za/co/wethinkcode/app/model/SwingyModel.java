package za.co.wethinkcode.app.model;

import java.util.Map;

public class SwingyModel {
	public SwingyModel() {
        	return ;
	}
	
    	// turn this into a factory
	private HeroBuilder _createHeroType(String type) {
        	HeroBuilder hBuilder;
        	if (type == "Witch") {
            		hBuilder = new Witch();
        	}
        	else {
            		hBuilder = new Witch();
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
