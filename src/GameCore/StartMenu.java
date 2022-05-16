package GameCore;

import GameElement.Char.Hero;
import GameElement.Char.Warrior;
import GameElement.Char.Wizard;
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
            hero = new Warrior("Arthur");
        } else if (heroSelected.equals("2")) {
            hero = new Wizard("Merlin");
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

    public String chooseDiff(){
        String choice = "";
        System.out.println("Veuillez selectionner votre difficulté de jeu, parceque j'ai eu des plaintes comme " +
                "quoi des gros nuls trouvaient le jeu trop dur :x");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*                 MENU                      *");
        System.out.println("* 1-Facile                                  *");
        System.out.println("* 2-Moyen                                   *");
        System.out.println("* 3-Dur                                     *");
        System.out.println("*                                           *");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        choice = clavier.nextLine();
        switch (choice){
            case "1" -> {
                return "1";
            }
            case "2" -> {
                return "2";
            }
            case "3" -> {
                return "3";
            }
            default -> chooseDiff();
        }

        System.out.println("Maintenant si tu perds, c'est juste parceque t'es nul");
        return choice;
    }
    public void displayMenu(Game pGame, Hero pHero) {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*                 MENU                      *");
        System.out.println("* 1-Sauvegarder la partie                   *");
        System.out.println("* 2-Recommencer la partie                   *");
        System.out.println("* 3-voir les stats du héro                  *");
        System.out.println("* 4-Changer le nom du héro                  *");
        System.out.println("* 5-Quitter la partie                       *");
        System.out.println("* 6-Quitter le menu                         *");
        System.out.println("*                                           *");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        String answer = clavier.nextLine();
        switch (answer) {
            case "1" -> System.out.println("Désolé, la fonction n'existe pas encore");
            case "2" -> pGame.cyclingGame(pHero);
            case "3" -> System.out.println(pHero);
            case "4" -> this.defineName(pHero);
            case "5" -> System.exit(0);
            case "6" -> pGame.nextStep(pHero);
            default -> {
                System.out.println("************///////////////Merci de faire un choix !//////////////////********************");
                displayMenu(pGame, pHero);
            }
        }
    }

}