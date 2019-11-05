package za.co.wethinkcode.app.model;

public class SwingyModel {
	public SwingyModel() {
        return ;
    }

	public void createHero(String hName) {
		HeroBuilder oBuilder = new OldHeroBuilder();
        HeroEngineer hEngineer = new HeroEngineer(oBuilder);
		
        hEngineer.makeHero(hName);

        Hero fHero = hEngineer.getHero();

        System.out.println("\nHero Built");
        System.out.println(fHero.toString());
        return ;
	}
}