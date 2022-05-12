package GameCore;
import GameElement.GameElement;

import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;
public class RollTheDice {
    public Integer launchDice(int randomLimit){
        Double randValue;
        randValue = (Math.random() * randomLimit)+1 ;
        int result = (int)Math.floor(randValue);
//        System.out.println("Resultat du dé : "+result);
        return result;
    }
    public Integer replaceDiceLaunch(GameElement enemy){
        Double randValue;
        int boardLimit = 64-enemy.getPosition()+1;
        randValue = (enemy.getPosition()+2) + (Math.random() * boardLimit) ;
        Integer result = (int)Math.floor(randValue);
        return result;
    }
}
