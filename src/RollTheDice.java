import java.lang.Math;
public class RollTheDice {
    public Integer lunchDice(){
        Double randValue;
        randValue = (Math.random() * 6) +1;
        Integer result = (int)Math.round(randValue);
        return result;
    }
}
