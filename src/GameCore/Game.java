package GameCore;

import Char.*;

public class Game {
    private StartMenu menu;
    private RollTheDice launchDice = new RollTheDice();

    public Game(StartMenu pMenu){
        menu = pMenu;

    }// Construct StartMenu Object
    public void playerTurn(Hero theHero, StartMenu menu){
        System.out.println("Le jeu va maintenant commencer");
        while (theHero.getPosition()<64){
            this.nextStep(theHero);
        }
        System.out.println("Jeux finit !");

    }//Advance into game

    public void nextStep(Hero hero){
        System.out.println("Vous êtes sur la case " + hero.getPosition() +
                ". /menu pour ouvrir le menu.");
        System.out.println("Pour continuer, merci d'appuyer sur \"entrée\"");
        String check = menu.clavier.nextLine();
        switch (check) {
            case "" -> hero.setPosition(hero.getPosition() + launchDice.launchDice(6));
            case "/menu"->menu.displayMenu(this, hero);
            default -> nextStep(hero);
        }

    }//Lunch the dice and select if continue/edit or quit

    public void gameCycle(Hero pHero){
        menu.start();
        pHero = menu.charSelection();
        this.playerTurn(pHero, menu);

    }//core Game Method

    public void cyclingGame(Hero phero){
        int gameCount = 0;
        boolean iterateGame = true;
        while(iterateGame){
            System.out.println("Partie numéro "+gameCount);
            gameCycle(phero);
            gameCount++;
        }
    }

//   public void generateEnemies(){
//        for(int i = 0; i < limitEnemy; i++){
//            int resultDice = launchDice.launchDice(3);
//            switch (resultDice){
//                case 1:
//                    listOfEnemy[i] = new Gobelin();
//                case 2:
//                    listOfEnemy[i] = new Sorcerer();
//                case 3:
//                    listOfEnemy[i] = new Dragon();
//            }
//        }
//    }
}
