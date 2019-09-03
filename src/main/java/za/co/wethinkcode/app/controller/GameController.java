package za.co.wethinkcode.app.controller;

import java.util.Scanner;

import za.co.wethinkcode.app.model.Hero;
import za.co.wethinkcode.app.model.HeroBuilder;
import za.co.wethinkcode.app.model.HeroEngineer;
import za.co.wethinkcode.app.model.OldHeroBuilder;

public class GameController {
    public GameController() { return ; }

    public void createHero() {
        HeroBuilder oBuilder = new OldHeroBuilder();
        HeroEngineer hEngineer = new HeroEngineer(oBuilder);
        Scanner inputName = new Scanner(System.in);

        System.out.print("Enter Hero Name: ");
        String hName = inputName.nextLine();
        // inputName.close();
        hEngineer.makeHero(hName);

        Hero fHero = hEngineer.getHero();

        System.out.println("\nHero Built");
        System.out.println("Hero Name: " + fHero.getHeroName());
        return ;
    }
}
