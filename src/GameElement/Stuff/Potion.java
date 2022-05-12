package GameElement.Stuff;

import GameElement.Char.Hero;
import GameElement.GameElement;

abstract public class Potion extends Stuff {
    private String name;
    private int regenHealth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegenHealth() {
        return regenHealth;
    }

    public void setRegenHealth(int regenHealth) {
        this.regenHealth = regenHealth;
    }

    @Override
    public void interaction(Hero pHero) {
        System.out.println("Vous avez trouvé une potion !");
        System.out.println("C'est une " + this.getName() + " elle peut te rendre " + this.getRegenHealth() + " point de dégats.");
        if (pHero.getHealth() + this.getRegenHealth() <= pHero.getMaximumHealth()) {
            pHero.setMaximumHealth(pHero.getHealth() + this.getRegenHealth());
        } else {
            pHero.setMaximumHealth(pHero.getHealth() + this.getRegenHealth());
        }
        pHero.setHealth(pHero.getHealth() + this.getRegenHealth());


    }
}
