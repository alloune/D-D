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
                ". Exit, Edit, Continue = n'importe quelle touche ");
        String check = menu.clavier.nextLine();
        switch (check) {
            case "Exit" -> System.exit(0);
            case "Edit" -> {
                menu.defineName(hero);
                nextStep(hero);
            }
            case "" -> hero.setPosition(hero.getPosition() + launchDice.launchDice(6));
            case "/stat"-> System.out.println(hero);
            default -> nextStep(hero);
        }

    }//Lunch the dice and select if continue/edit or quit

    public void gameCycle(Hero pHero){
        menu.start();
        pHero = menu.charSelection();
        this.playerTurn(pHero, menu);

        gameCycle(pHero);


    }//core Game Method



//   public void generateEnemies(){
//        for(int i = 0; i < limitEnemy; i++){
//            int resultDice = launchDice.launchDice(3);
//            switch (resultDice){
//                case 1:
//                    listOfEnemy[i] = new Gobelin();
//                case 2:
//                    listOfEnemy[i] = new Sorcer();
//                case 3:
//                    listOfEnemy[i] = new Dragon();
//            }
//        }
//    }
}
