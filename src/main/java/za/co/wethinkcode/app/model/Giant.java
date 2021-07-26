package za.co.wethinkcode.app.model;

import za.co.wethinkcode.app.core.GameMap;

import java.util.Map;

public class Giant implements HeroBuilder {
    private final Hero _hero;

    public Giant() {
        _hero = new Hero();
    }

    @Override
    public void buildHero(String name) {
        _hero.setHeroName(name);
        _hero.setHeroType("Goblin");
        _hero.setHeroXP(50);
        _hero.setHeroHP(3275);
        _hero.setHeroLevel(1);
        _hero.setHeroAttack(211);
        _hero.setHeroDefence(300);
        _hero.setHeroArtifact("");
	    _hero.setHeroExperience(1500);

        _hero.setHeroX(GameMap._mapSize / 2);
        _hero.setHeroY(GameMap._mapSize / 2);
    }

    @Override
    public void buildCustomHero(Map<String,String> heroDets) { }

    @Override
    public Hero getHero() { return _hero; }
}
