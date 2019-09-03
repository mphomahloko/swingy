package za.co.wethinkcode.app.model;

public class OldHeroBuilder implements HeroBuilder {
    private Hero _hero;

    public OldHeroBuilder() {
        _hero = new Hero();
        return ;
    }

    @Override
    public void buildHeroName(String name) {
        _hero.setHeroName(name);
        return ;
    }

    @Override
    public Hero getHero() { return _hero; }
}
