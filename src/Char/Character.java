package Char;

abstract public class  Character {

   private int strength;
   private Integer health;
   private Integer position;
   private String nature;

    public Integer getStrength() {
        return strength;
    }
    public void setStrength(Integer strength) {
        this.strength = strength;
    }
    public Integer getHealth() {
        return health;
    }
    public void setHealth(Integer health) {
        this.health = health;
    }
    public Integer getPosition() {
        return position;
    }
    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getNature() {
        return nature;
    }
}
