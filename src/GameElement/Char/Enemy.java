package GameElement.Char;

import GameCore.RollTheDice;
import GameElement.GameElement;
import GameElement.Interact;
import java.util.List;

public abstract class Enemy extends Character implements Interact {
    public Enemy(int hp, int strength, String enemyClass){
        this.setHealth(hp);
        this.setStrength(strength);
        this.setNature(enemyClass);
        this.setStatus("Enemy");

    }

    @Override
    public void interaction(Hero pHero) {
        System.out.println("******************************************");
        System.out.println("        C'est l'heure du duel yu-gi !     ");
        System.out.println("******************************************");

        System.out.println("******************************************");
        System.out.println(" Le "+this.getNature() +" t'inflige "+this.getStrength()+" point de dégats. !");
        System.out.println("******************************************");

        System.out.println("Vous lui infligez "+pHero.getStrength() +" point de dégats.");

        pHero.setHealth(pHero.getHealth()-this.getStrength());
        this.setHealth(this.getHealth()- pHero.getStrength());
    }

    public void isDead(List<GameElement> allGameElement){
        if(this.getHealth()<=0){
            System.out.println("Le" + this.getNature()+" est désintégré ! bravo");
        }
        else{
            RollTheDice diceLaunch = new RollTheDice();
            int answer = diceLaunch.replaceDiceLaunch(this);
            for (GameElement element: allGameElement
                 ) {if(answer == element.getPosition()){



            }


            }
        }
    }
}
