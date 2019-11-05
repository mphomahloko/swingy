package za.co.wethinkcode.app.model;

public class HeroEngineer {
    private HeroBuilder _heroBuilder;

    public HeroEngineer(HeroBuilder heroBuilder) {
        _heroBuilder = heroBuilder;
        return ;
    }

    public Hero getHero() { return _heroBuilder.getHero(); }

    public void makeHero(String name) {
        _heroBuilder.buildHero(name);
        return ;
    }
}
