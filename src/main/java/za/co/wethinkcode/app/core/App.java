package za.co.wethinkcode.app.core;

import za.co.wethinkcode.app.controller.ConsoleController;

/**
 *  Entry point
 */

public class App {
    public static void main( String[] args )
    {
        try
        {
            if (args[0].equals("console")) { new ConsoleController(); }
            else if (args[0].equals("gui")) { System.out.println("gui"); }

        }catch(Exception e) {
            System.out.println("Please choose weather to run in gui or console.");
        }
    
        // HeroBuilder oBuilder = new OldHeroBuilder();

        // HeroEngineer hEngineer = new HeroEngineer(oBuilder);

        // hEngineer.makeHero();

        // Hero fHero = hEngineer.getHero();

        // System.out.println("\nHero Built");
        // System.out.println("Hero Name: " + fHero.getHeroName());
    }
}
