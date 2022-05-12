package GameElement.Stuff;

import GameElement.Char.Hero;

public abstract class Weapon extends Stuff {
    private String name;
    private int strength;
    private String user;

    public int getStrength() {
        return strength;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void interaction(Hero pHero) {
        System.out.println("Vous avez trouvé un trésor !");
        System.out.println("C'est : " + this.getName());
        if(this.getUser() == pHero.getHeroClass()){
            System.out.println("Vous pouvez vous en équiper. Ce trésor vous donne jusqu'a "+this.getStrength()+" point de dégat");
            if(pHero.getStrength() + this.getStrength() <= pHero.getMaximumStrength()){
                pHero.setStrength(pHero.getStrength()+this.getStrength());
            }
            else {
                pHero.setStrength(pHero.getMaximumStrength());
            }
        }
        else {
            System.out.println("Malheuresement, cet équipement est utile à l'autre classe");
        }
    }

}
