package GameCore;

import Char.Hero;
import Char.Warrior;
import Char.Wizard;
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


    public Hero charSelection() {
        System.out.println("Quel héro voulez vous prendre ? 1 = Guerrier, 2 = Magicien");
        String chosenHero = clavier.nextLine();
        Hero hero;

        try {

            hero = this.createChar(chosenHero);
        } catch (BadHeroSelection err) {
            System.err.println(err);
            hero = new Warrior();
            this.defineName(hero);
        }
        return hero;
    }//Ask for Hero

    public Hero createChar(String heroSelected) throws BadHeroSelection {

        Hero hero;

        if (heroSelected.equals("1")) {
            hero = new Warrior();
        } else if (heroSelected.equals("2")) {
            hero = new Wizard();
        } else {
            throw new BadHeroSelection("Tu n'as pas choisis de personnages suivant les règles. Tu auras donc un pecno de Guerrier");
        }

        this.defineName(hero);
        return hero;
    }//Create hero, and throws error if input doesn't belong to if case


    public void defineName(Hero hero) {
        String name;
        System.out.println("Maintenant, merci d'entrer le nom de ton Héro ! " +
                "Quelque chose qui pète, Mais tkt , tu pourras le changer.");
        name = clavier.nextLine();
        hero.setName(name);
        System.out.println(hero);
    }


}

