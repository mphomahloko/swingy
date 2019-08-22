package za.co.wethinkcode.app.core;

import za.co.wethinkcode.app.model.Hero;
import za.co.wethinkcode.app.model.HeroBuilder;
import za.co.wethinkcode.app.model.HeroEngineer;
import za.co.wethinkcode.app.model.OldHeroBuilder;

/**
 *  
 */
public class App {
    public static void main( String[] args )
    {
        HeroBuilder oBuilder = new OldHeroBuilder();

        HeroEngineer hEngineer = new HeroEngineer(oBuilder);

        hEngineer.makeHero();

        Hero fHero = hEngineer.getHero();

        System.out.println("\nHero Built");
        System.out.println("Hero Name: " + fHero.getHeroName());
    }
}
