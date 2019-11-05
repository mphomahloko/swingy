package za.co.wethinkcode.app.model;

public interface HeroPlan {
/*              Hero Name                                                      */
    public void setHeroName(String name);
    public String getHeroName();

/*                       Hero Id                                               */
    public void setHeroId(Integer id);
    public Integer getHeroId();

/*                      Hero Type                                              */
    public void setHeroType(String type);
    public String getHeroType();

/*                     Hero Xp                                                 */
    public void setHeroXP(Integer xp);
    public Integer getHeroXP();

/*                     Hero Hp                                                 */
    public void setHeroHP(Integer hp);
    public Integer getHeroHP();

/*                     Hero Level                                              */
    public void setHeroLevel(Integer level);
    public Integer getHeroLevel();

/*                     Hero attack                                            */
    public void setHeroAttack(Integer attack);
    public Integer getHeroAttack();

/*                    Hero Defence                                            */
    public void setHeroDefence(Integer defence);
    public Integer getHeroDefence();

/*                    Hero Artifact                                           */
    public void setHeroArtifact(String artifact);
    public String getHeroArtifact();

/*                   Hero Position                                            */
    public void setHeroX(Integer x);
    public Integer getHeroX();

    public void setHeroY(Integer y);
    public Integer getHeroY();
}
