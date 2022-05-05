package GameCore;

import java.lang.Math;
public class RollTheDice {
    public Integer launchDice(int randomLimit){
        Double randValue;
        randValue = (Math.random() * randomLimit)+1 ;
        Integer result = (int)Math.floor(randValue);
        System.out.println("Resultat du dé : "+result);
        return result;
    }
}
