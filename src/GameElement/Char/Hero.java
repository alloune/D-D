package GameElement.Char;

abstract public class Hero extends Character {

    private String image;
    private String name;
    private String heroClass;
    protected Hero(){

    }
    protected Hero(String name, int hp, int strg, String heroClass, int maximumHealth, int maximumStrength ) {
        this.setName(name);
        this.setHealth(hp);
        this.setStrength(strg);
        this.setHeroClass(heroClass);
        this.setPosition(1);
        this.setStatus("Hero");
        this.setMaximumStrength(maximumStrength);
        this.setMaximumHealth(maximumHealth);
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
    return "Nom = "+this.getName() +"\n"+
            "Classe = "+ this.getHeroClass() +"\n"+
            "Santé = " + this.getHealth() + " points de vie" +"\n"+
            "Force = "+this.getStrength() + " point de force" +"\n"+
            "Position = "+this.getPosition()+"\n";
    }

    @Override
    public void interaction(Hero pHero){

    }

}
