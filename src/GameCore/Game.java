package GameCore;

import GameElement.Char.*;
import GameElement.GameElement;

import java.sql.ResultSet;

public class Game {
    /**
     * Stock the menu in the GameObject once created
     */
    private StartMenu menu;
    /**
     * Stock the board in the GameObject once created
     */
    private Board board;
    /**
     * Stock the dice in the GameObject once created
     */
    private RollTheDice launchDice = new RollTheDice();

    /**
     * Construct to prepare changement to Menu and Board object
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
     *
     * @param theHero Player's hero to update
     * @param menu    Instance of Menu to get method
     */
    public void playerTurn(Hero theHero, StartMenu menu) {
        System.out.println("Le jeu va maintenant commencer");
        while (theHero.getPosition() < 64 && theHero.getHealth() > 0) {
            this.nextStep(theHero);
            System.out.println(theHero);
        }
        System.out.println("Jeu fini !");
        if (theHero.getHealth() <= 0) {

            System.out.println("Tu as perdu la partie :x Essaie d'être un peu moins nul la prochaine fois");
        } else {
            System.out.println("Bravo jeune Hero ! Tu es devenu un chêne fort et puissant capable de venir a bout de n'importe qui !\n\n\n");
        }

    }

    /**
     * Describe a step of the game
     *
     * @param pHero Player's hero to update
     */
    public void nextStep(Hero pHero) {
        System.out.println("Pour continuer, merci d'appuyer sur \"entrée\" (/menu pour les options)");
        String check = menu.clavier.nextLine();
        switch (check) {
            case "" -> pHero.setPosition(pHero.getPosition() + launchDice.launchDice(6));
            case "/menu" -> menu.displayMenu(this, pHero);
            default -> nextStep(pHero);
        }
        resolveInteraction(pHero);


    }//Lunch the dice and select if continue/edit or quit

    /**
     * Create the menu, choose the Hero
     *
     * @param pHero Player's hero to update
     */
    public void gameCycle(Hero pHero) {
        menu.start();
        pHero = menu.charSelection();
        this.playerTurn(pHero, menu);

    }//core Game Method

    /**
     * The core of the game. Count each loop of game instance
     *
     * @param pHero Player's hero to update
     */
    public void cyclingGame(Hero pHero) {
        int gameCount = 0;
        boolean iterateGame = true; // à voir, y a peut-être mieux comme technique
        while (iterateGame) {
            System.out.println("Partie numéro " + gameCount);
//                                                                                                                             ");
            gameCycle(pHero);
            gameCount++;
        }
    }

    /**
     * Check if player encounter Game Element
     *
     * @param pHero Player's hero to update
     */
    public void resolveInteraction(Hero pHero) {
        GameElement specificElement = null;
        for (GameElement element : this.board.getAllGameObject()
        ) {
            if (element.isInteraction(pHero, element) != null) {
                specificElement = element.isInteraction(pHero, element);
                specificElement.interaction(pHero);
            }
        }

    }
}
