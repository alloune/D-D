abstract class  Character {

   private Integer strength;
   private Integer health;
   private Integer position;

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getHealth() {
        return health;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getStrength() {
        return strength;
    }
}
