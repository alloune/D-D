package Char;

abstract public class Hero extends Character {

    private String image;
    private String name;
    private String heroClass;
    protected Hero(){

    }
    protected Hero(String name, int hp, int strg, String heroClass) {
        this.setName(name);
        this.setHealth(hp);
        this.setStrength(strg);
        this.setHeroClass(heroClass);
        this.setPosition(1);
    }

    public void setImage(String imageAddress) {
        this.image = imageAddress;
    }

    public String getImage() {
        return this.image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public String getHeroClass() {
        return this.heroClass;
    }

    @Override
    public String toString() {
        return this.getName() + " un jeune gland de " + this.getHeroClass() + " qui espère devenir fort et grand comme un chêne." + " Il a " + this.getHealth() + " points de vie, " + this.getStrength() + " point de force en position " + this.getPosition();
    }
}
