package GameCore;
import java.util.Scanner;
import Char.Hero;
import Char.Warrior;

public class Game {
    public void restartGame(){
        Scanner clavier = new Scanner(System.in);
        String check = clavier.nextLine();
        StartMenu toto = new StartMenu();
        if(check.equalsIgnoreCase("r")){
            toto.start();
        }
    }
    public void coreGame(Hero theHero, StartMenu menu){
        System.out.println("Le jeu va maintenant commencer");
        while (theHero.getPosition()<64){
            menu.nextStep(theHero);
        }
        System.out.println("Jeux finit !");
        theHero = new Warrior();
        coreGame(theHero, menu);
    }

}
