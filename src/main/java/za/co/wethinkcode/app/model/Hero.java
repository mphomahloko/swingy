package za.co.wethinkcode.app.model;

public class Hero implements HeroPlan {
    private String _name;

    @Override
    public void setHeroName(String name) {
        _name = name;
        return ;
    }

    public String getHeroName() { return _name; }
}
