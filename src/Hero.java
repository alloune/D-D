public class Hero extends Character {

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
    public void setName(String name){
        this.image = name;
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

}
