import Char.Hero;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        Hero hero;
        StartMenu toto = new StartMenu();
        toto.start();
        hero = toto.charSelection();
        System.out.println("Le jeu va maintenant commencer");
        toto.coreGame(hero);
        String check = clavier.nextLine();
        if(check.equalsIgnoreCase("r")){
            toto.start();
        }
    }
}

