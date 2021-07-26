package za.co.wethinkcode.app.model;

import java.util.Map;

public interface HeroBuilder {
    void buildHero(String name);
    void buildCustomHero(Map<String,String> heroDets);
    Hero getHero();
}
