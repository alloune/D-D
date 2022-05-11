package GameCore;

import java.util.stream.Stream;
import java.util.List;

import GameElement.Char.*;
import GameElement.Char.Character;
import GameElement.GameElement;

public class Game {
    private StartMenu menu;
    private Board board;
    private RollTheDice launchDice = new RollTheDice();

    /**
     *
     * @param pMenu
     * @param pBoard
     */

    public Game(StartMenu pMenu, Board pBoard) {
        menu = pMenu;
        board = pBoard;

    }

    /**
     * Advance into the game
     * @param theHero
     * @param menu
     */
    public void playerTurn(Hero theHero, StartMenu menu) {
        System.out.println("Le jeu va maintenant commencer");
        while (theHero.getPosition() < 64 && theHero.getHealth()>0) {
            this.nextStep(theHero);
        }
        System.out.println("Jeux finit !");

    }

    /**
     *
     * @param hero
     */
    public void nextStep(Hero hero) {
        System.out.println("Vous êtes sur la case " + hero.getPosition() +
                ". /menu pour ouvrir le menu.");
        System.out.println("Pour continuer, merci d'appuyer sur \"entrée\"");
        String check = menu.clavier.nextLine();
        switch (check) {
            case "" -> hero.setPosition(hero.getPosition() + launchDice.launchDice(6));
            case "/menu" -> menu.displayMenu(this, hero);
            default -> nextStep(hero);
        }
        isInteraction(hero, board.getListOfCharacter());


    }//Lunch the dice and select if continue/edit or quit

    /**
     *
     * @param pHero
     */
    public void gameCycle(Hero pHero) {
        menu.start();
        pHero = menu.charSelection();
        this.playerTurn(pHero, menu);

    }//core Game Method

    /**
     * The core of the game. Count each loop of game instance
     * @param pHero
     */
    public void cyclingGame(Hero pHero) {
        int gameCount = 0;
        boolean iterateGame = true;
        while (iterateGame) {
            System.out.println("Partie numéro " + gameCount);
            gameCycle(pHero);
            gameCount++;
        }
    }

    public void isInteraction(Hero pHero, Character[] listOfCharacter) {

        for (GameElement element : board.getAllGameObject()) {
            if (element.getPosition() == pHero.getPosition()) {
                meetSomething();
                if (element.getStatus() == "Enemy") {
                    displayFight();
//                    checkClassOfChar(element);
                    resolveFight(checkClassOfChar(element), pHero);
                } else {
                    meetTreasure();
                }

            }

        }

    }

    public void resolveFight(Character enemyFighter, Hero pHero){
        int hpHero = pHero.getHealth();
        int strHero = pHero.getStrength();
        int hpEnemy = enemyFighter.getHealth();
        int strEnemy = enemyFighter.getStrength();

        pHero.setHealth(hpHero-strEnemy);
        hpHero = pHero.getHealth();
        enemyFighter.setHealth(hpEnemy-strHero);
        hpEnemy = enemyFighter.getHealth();

        fightGUI(strHero, enemyFighter.getNature(), strEnemy);
        if(hpHero<=0){
            System.out.println("Malheuresement, le coup vous a été fatal. Vous mangerez les pissenlits par la racine sur la case "+ pHero.getPosition()+ " pour un bon bout de temps");
        }
        else{
            System.out.println("La bataille était rude, vous voila avec "+ hpHero +" points de vie restant.");
            if(hpEnemy <= 0){
                System.out.println("Votre vaillance est venue à bout du " +enemyFighter.getNature()+".");
            }
            else{
                System.out.println("Le gredin de "+enemyFighter.getNature()+ " a réussit à s'enfuir ! Essaie de retrouver sa trace et de le défoncer !");
                board.enemyPositionAfterLose(enemyFighter);
            }

        }


    }

    public Character checkClassOfChar(GameElement elementToCheck) {
        Character result = null;
        if (elementToCheck instanceof Gobelin goblin) {
           result  = fightAgainst(goblin);
        } else if (elementToCheck instanceof Sorcerer sorcerer) {
           result = fightAgainst(sorcerer);
        } else if (elementToCheck instanceof Dragon dragon) {
           result = fightAgainst(dragon);

        }
        return result;
    }

    /////////Display////////////

    /**
     * Print against which type of enemy you will face.
     * @param whichCharacter
     * @return
     */
    public Character fightAgainst(Character whichCharacter) {
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•  ►        Tu es contre        ◄ •");
        System.out.println("•            " + whichCharacter.getNature() + "        ");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        return whichCharacter;
    }
    public void meetSomething(){
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•  ► Vous êtes sur la meme case ◄ •");
        System.out.println("•  ►    Qu'un autre élément     ◄ •");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
    }
    public void meetTreasure(){
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•  ►       C'est un trésor      ◄ •");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
    }
    public void displayFight() {
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•  ►       C'est un ennemi      ◄ •");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•  ►   Prépare toi au combat !  ◄ •");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

    }
    public void fightGUI(int heroStrength, String enemyNature, int enemyStrength){
        System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println("•                                              •");
        System.out.println("•                                              •");
        System.out.println("• ►        Dans un combat acharné contre◄      •");
        System.out.println("•  ►          Un "+enemyNature+"    ◄         •");
        System.out.println("•    Vous lui infligez "+heroStrength+" point de dégat    •");
        System.out.println("•    En revanche, il vous en inflige "+enemyStrength+"      •");
        System.out.println("•                                              •");
        System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

    }

}
