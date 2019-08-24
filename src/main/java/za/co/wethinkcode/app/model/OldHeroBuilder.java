package za.co.wethinkcode.app.model;

public class OldHeroBuilder implements HeroBuilder {
    private Hero _hero;

    public OldHeroBuilder() {
        _hero = new Hero();
        return ;
    }

    @Override
    public void buildHeroName() {
        _hero.setHeroName("give me a Name");
        return ;
    }

    @Override
    public Hero gethHero() { return _hero; }
}
