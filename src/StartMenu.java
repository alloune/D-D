import Char.Hero;
import Char.Warrior;
import Char.Wizard;
import Stuff.Stuff;
import execptions.BadHeroSelection;

import java.util.Scanner;

public class StartMenu {
    Scanner clavier = new Scanner(System.in);

    public void start() {

        Boolean startValue = false;
        String answer = null;
        System.out.println("Continuer le jeu (Y)");
        System.out.println("Fermer le jeu (X)");
        while (!startValue) {
            System.out.println("votre réponse ");
            answer = clavier.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                System.out.println("Vous lancez le jeu");
                startValue = true;
            }
            if (answer.equalsIgnoreCase("X")) {
                System.out.println("Vous fermez le jeu");
                System.exit(0);
            }
            if (startValue.equals(false))
                System.out.println("Merci d'entrer un caractère valide");
        }
    }


    public Hero charSelection()  {
        System.out.println("Quel héro voulez vous prendre ? 1 = Guerrier, 2 = Magicien");
        String chosenHero = clavier.nextLine();
        Hero hero;
        try {
            hero = chooseTheChar(chosenHero);
        } catch (BadHeroSelection err){
            hero = new Warrior();
            System.err.println(err);
        }
        return hero;
    }

    public Hero chooseTheChar(String heroSelected) throws BadHeroSelection{
        Scanner clavier = new Scanner(System.in);
        String name;
        Hero hero = null;

        if (heroSelected.equals("1")) {
            hero = new Warrior();
        }
        if (heroSelected.equals("2")) {
            hero = new Wizard();
        }
        else{
            throw new BadHeroSelection("raté!");
        }
        System.out.println("tu as choisis le : " + hero.getHeroClass());
        System.out.println("Maintenant, merci d'entrer le nom de ton Héro ! " +
                "Quelque chose qui pète, tu ne pourras plus le changer par la suite.");
        name = clavier.nextLine();
        hero.setName(name);

        System.out.println(hero.toString());
        return hero;
    }

    public void coreGame(Hero theHero) {

        while (theHero.getPosition() < 64) {

            System.out.println("Vous êtes sur la case " + theHero.getPosition() +
                    ". Cliquez sur n'importe quelle touche pour lancer le dé.(ou e pour quitter.)");
            String check = clavier.nextLine();
            if (check.equalsIgnoreCase("e")) {

                System.exit(0);

            }
            RollTheDice lunch = new RollTheDice();
            theHero.setPosition(theHero.getPosition() + lunch.lunchDice());

        }
        if (theHero.getPosition() >= 64) {
            System.out.println("Bravo !! Tu as finis le jeu :), entrée pour quitter, r pour rejouer");

        }
    }


}

