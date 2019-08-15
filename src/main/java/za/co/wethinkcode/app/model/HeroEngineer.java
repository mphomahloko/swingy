package za.co.wethinkcode.app.model;

public class HeroEngineer {
    private HeroBuilder _heroBuilder;

    public HeroEngineer(HeroBuilder heroBuilder) {
        _heroBuilder = heroBuilder;
        return ;
    }

    public Hero getHero() { return _heroBuilder.gethHero(); }

    public void makeHero() {
        _heroBuilder.buildHeroName();
        return ;
    }
}
