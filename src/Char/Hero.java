package Char;

abstract public class Hero extends Character {

    private String image;
    private String name;
    private String heroClass;
    public Hero(){
        this.setPosition(1);
    }



    public void setImage(String imageAddress){
        this.image = imageAddress;
    }
   public String getImage(){
        return this.image;
   }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setHeroClass(String heroClass){
        this.heroClass = heroClass;
    }
    public String getHeroClass(){
        return this.heroClass;
    }

    @Override
    public String toString() {
        return  this.getName() + " un jeune gland de "+this.getHeroClass()+" qui espère devenir un fort et grand comme un chêne."+ " Il a " + this.getHealth()+ " points de vie, "+this.getStrength()+" point de force. Vous etes sur la case "+this.getPosition() ;
    }
}
