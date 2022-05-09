package GameElement.Char;

import GameElement.GameElement;

abstract public class  Character extends GameElement {

   private int strength;
   private Integer health;
   private String nature;
   public Character(){

   }
   public Character(int hp, int str, String nature){
       this.setHealth(hp);
       this.setStrength(str);
       this.setPosition(0);
       this.setStatus("Enemy");
       this.setNature(nature);
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
