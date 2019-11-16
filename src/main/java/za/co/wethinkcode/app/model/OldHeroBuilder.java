package za.co.wethinkcode.app.model;

import java.util.Map;

    /* types of heros */
public class OldHeroBuilder implements HeroBuilder {
    private Hero _hero;

    public OldHeroBuilder() {
        _hero = new Hero();
        return ;
    }

    @Override
    public void buildHero(String name) {
        _hero.setHeroName(name);
        _hero.setHeroType("Witch");
        _hero.setHeroXP(50);
        _hero.setHeroHP(150);
        _hero.setHeroLevel(1);
        _hero.setHeroAttack(10);
        _hero.setHeroDefence(5);
        _hero.setHeroArtifact("");

        _hero.setHeroX(20 / 2);
        _hero.setHeroY(20 / 2);
        return ;
    }

    @Override
    public void buildCustomHero(Map<String,String> heroDets) { return ; }

    @Override
    public Hero getHero() { return _hero; }
}
