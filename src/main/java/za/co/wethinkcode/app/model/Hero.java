package za.co.wethinkcode.app.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Hero implements HeroPlan {
    @NotBlank(message = "hero name Should not be null")
    @Size(message = "hero name should be between 3 and 15", min = 3, max = 15)
    private String _name;
    private Integer _id;

    private String _type;
    private Integer _xp;
    private Integer _hp;
    private Integer _level;

    private Integer _attack;
    private Integer _defence;
    private String _artifact;
    private Integer _experience;

    private Integer _x;
    private Integer _y;

    @Override
    public void setHeroName(String name) {
        _name = name;
    }

    @Override
    public String getHeroName() { return _name; }

    @Override
    public void setHeroId(Integer id) {
        _id = id;
    }

    @Override
    public Integer getHeroId() { return _id; }

    @Override
    public void setHeroType(String type) {
        _type = type;
    }

    @Override
    public String getHeroType() { return _type; }

    @Override
    public void setHeroXP(Integer xp) {
        _xp = xp;
    }

    @Override
    public Integer getHeroXP() { return _xp; }

    @Override
    public void setHeroHP(Integer hp) {
        _hp = hp;
    }

    @Override
    public Integer getHeroHP() { return _hp; }

    @Override
    public void setHeroLevel(Integer level) {
        _level = level;
    }

    @Override
    public Integer getHeroLevel() { return _level; }

    @Override
    public void setHeroAttack(Integer attack) {
        _attack = attack;
    }

    @Override
    public Integer getHeroAttack() { return _attack; }

    @Override
    public void setHeroDefence(Integer defence) {
        _defence = defence;
    }

    @Override
    public Integer getHeroDefence() { return _defence; }

    @Override
    public void setHeroArtifact(String artifact) {
        _artifact = artifact;
    }

    @Override
    public String getHeroArtifact() { return _artifact; }

    @Override
    public void setHeroExperience(Integer experience) {
	    _experience = experience;
    }

    @Override
    public Integer  getHeroExperience() { return _experience; }

    @Override
    public void setHeroX(Integer x) {
        _x = x;
    }

    @Override
    public Integer getHeroX() { return _x; }

    @Override
    public void setHeroY(Integer y) {
        _y = y;
    }

    @Override
    public Integer getHeroY() { return _y; }

    @Override
    public String toString() { 
        return "id: " + _id + '\n' +
                "Name: " + _name + '\n' +
                "Type: " + _type + '\n' +
                "XP: " + _xp + '\n' +
                "HP: " + _hp + '\n' +
                "Level: " + _level + '\n' +
                "Attack: " + _attack + '\n' +
                "Artifact: " + _artifact + '\n' +
                "Experience: " + _experience + '\n' +
                "Defence: " + _defence + '\n' +
                "x coordinate: " + _x + '\n' +
                "y coordinate: " + _y + '\n';
    }
}
