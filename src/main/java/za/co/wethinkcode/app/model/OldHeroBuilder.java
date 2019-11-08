package za.co.wethinkcode.app.model;

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
        _hero.setHeroXP(50);
        _hero.setHeroHP(150);
        _hero.setHeroLevel(1);
        _hero.setHeroAttack(10);
        _hero.setHeroDefence(5);
        _hero.setHeroArtifact("");

        _hero.setHeroX(0);
        _hero.setHeroY(0);
        return ;
    }

    @Override
    public Hero getHero() { return _hero; }
}
