package za.co.wethinkcode.app.model;

import java.util.Map;

public interface HeroBuilder {
    public void buildHero(String name);
    public void buildCustomHero(Map<String,String> heroDets);
    public Hero getHero();
}
