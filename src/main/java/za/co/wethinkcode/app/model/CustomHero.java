package za.co.wethinkcode.app.model;

import java.util.Map;
    /* types of heros */
public class CustomHero implements HeroBuilder {
    private Hero _hero;

    public CustomHero() {
        _hero = new Hero();
        return ;
    }

    @Override
    public void buildHero(String name) {
        return ;
    }

    @Override
    public void buildCustomHero(Map<String,String> heroDets) {

        _hero.setHeroName(heroDets.get("name"));
        _hero.setHeroId(Integer.parseInt(heroDets.get("id")));
        _hero.setHeroType(heroDets.get("type"));
        _hero.setHeroXP(Integer.parseInt(heroDets.get("xp")));
        _hero.setHeroHP(Integer.parseInt(heroDets.get("hp")));
        _hero.setHeroLevel(Integer.parseInt(heroDets.get("level")));
        _hero.setHeroAttack(Integer.parseInt(heroDets.get("attack")));
        _hero.setHeroDefence(Integer.parseInt(heroDets.get("defence")));
        _hero.setHeroArtifact(heroDets.get("artifact"));

        _hero.setHeroX(Integer.parseInt(heroDets.get("x")));
        _hero.setHeroY(Integer.parseInt(heroDets.get("y")));
    }
    
    @Override
    public Hero getHero() { return _hero; }
}
