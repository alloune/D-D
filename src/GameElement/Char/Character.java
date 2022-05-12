package GameElement.Char;

import GameElement.GameElement;

abstract public class  Character extends GameElement {

   private int strength;
   private Integer health;
   private String nature;
   private int maximumHealth;
   private int  maximumStrength;

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public void setMaximumHealth(int maximumHealth) {
        this.maximumHealth = maximumHealth;
    }

    public int getMaximumStrength() {
        return maximumStrength;
    }

    public void setMaximumStrength(int maximumStrength) {
        this.maximumStrength = maximumStrength;
    }

    public Character(){

   }


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
    public void setNature(String nature) {
        this.nature = nature;
    }
    public String getNature() {
        return nature;
    }

}
