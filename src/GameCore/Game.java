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

    public Game(StartMenu pMenu, Board pBoard) {
        menu = pMenu;
        board = pBoard;

    }// Construct StartMenu Object

    public void playerTurn(Hero theHero, StartMenu menu) {
        System.out.println("Le jeu va maintenant commencer");
        while (theHero.getPosition() < 64) {
            this.nextStep(theHero);
        }
        System.out.println("Jeux finit !");

    }//Advance into game

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

    public void gameCycle(Hero pHero) {
        menu.start();
        pHero = menu.charSelection();
        this.playerTurn(pHero, menu);

    }//core Game Method

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


                System.out.println("•••••••••••••••••••••••••••••••••••");
                System.out.println("•                                 •");
                System.out.println("•                                 •");
                System.out.println("•  ► Vous êtes sur la meme case ◄ •");
                System.out.println("•  ►    Qu'un autre élément     ◄ •");
                System.out.println("•                                 •");
                System.out.println("•                                 •");
                System.out.println("•••••••••••••••••••••••••••••••••••");
                System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

                if (element.getStatus() == "Enemy") {
                    displayFight();
                    checkClassOfChar(element);
                    }

                } else {
                    System.out.println("•••••••••••••••••••••••••••••••••••");
                    System.out.println("•                                 •");
                    System.out.println("•                                 •");
                    System.out.println("•  ►       C'est un trésor      ◄ •");
                    System.out.println("•                                 •");
                    System.out.println("•                                 •");
                    System.out.println("•••••••••••••••••••••••••••••••••••");
                    System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
                }

            }

        }

    public void displayFight(){
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
    public void fightAgainst(Character whichCharacter){
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•  ►        Tu es contre        ◄ •");
        System.out.println("•  ►           "+ whichCharacter.getNature() +"     ◄ •");
        System.out.println("•                                 •");
        System.out.println("•                                 •");
        System.out.println("•••••••••••••••••••••••••••••••••••");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
    }
    public void checkClassOfChar(GameElement elementToCheck){
        if(elementToCheck instanceof Gobelin goblin){
            fightAgainst(goblin);
        }else if(elementToCheck instanceof Sorcerer sorcerer){
            fightAgainst(sorcerer);
        } else if (elementToCheck instanceof Dragon dragon) {
            fightAgainst(dragon);

        }

    }
}
