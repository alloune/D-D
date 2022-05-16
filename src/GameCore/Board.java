package GameCore;

import GameElement.Char.*;
import GameElement.Char.Character;
import GameElement.Stuff.*;
import GameElement.GameElement;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Board {
    private RollTheDice diceMethods = new RollTheDice();// a améliorer, on doit pouvoir le virer d'ici
    private Character[] listOfCharacter;// Je recupère tous les ennemis
    private Stuff[] listOfStuff;// je recupère tous les stuffs
    private int enemyCount = 20;
    private int treasureCount = 25;
    private int totalOfObject = enemyCount + treasureCount;
    /**
     * Create a collection of all game Elements
     */
    private List<GameElement> allGameObject = new ArrayList<GameElement>(totalOfObject);

    public Board() {
        listOfCharacter = new Character[enemyCount];
        listOfStuff = new Stuff[treasureCount];
    }

    public void setListOfCharacter(Character[] listOfCharacter) {
        this.listOfCharacter = listOfCharacter;
    }

    public void setListOfStuff(Stuff[] listOfStuff) {
        this.listOfStuff = listOfStuff;
    }

    public RollTheDice getDiceMethods() {
        return diceMethods;
    }



    /**
     * Get a collection of game Element. Character/Stuff/Potion
     * @return
     */
    public List<GameElement> getAllGameObject() {
        return allGameObject;
    }

    public void setAllGameObject(List<GameElement> allGameObject) {
        this.allGameObject = allGameObject;
    }

    public void generateEnemy(double diff) {
        for (int i = 0; i < Math.floor(enemyCount*diff); i++) {
            int diceResult = diceMethods.launchDice(3);
            switch (diceResult) {
                case 1 -> {
                    listOfCharacter[i] = new Gobelin();
                    listOfCharacter[i].setNature("gobelin");
                }
                case 2 -> {
                    listOfCharacter[i] = new Dragon();
                    listOfCharacter[i].setNature("dragon");
                }
                case 3 -> {
                    listOfCharacter[i] = new Sorcerer();
                    listOfCharacter[i].setNature("sorcerer");
                }
            }

        }


    }

    public void generateTreasure(double diff) {
        for (int i = 0; i < Math.floor(treasureCount*diff); i++) {
            int diceResult = diceMethods.launchDice(6);
            switch (diceResult) {
                case 1 -> {
                    listOfStuff[i] = new BigPotion();
                }
                case 2 -> {
                    listOfStuff[i] = new StandardPotion();
                }
                case 3 -> {
                    listOfStuff[i] = new FireBlast();
                }
                case 4 -> {
                    listOfStuff[i] = new Bolt();
                }
                case 5 -> {
                    listOfStuff[i] = new Mass();
                }
                case 6 -> {
                    listOfStuff[i] = new Sword();
                }
            }

        }
    }

    public void fillTable(GameElement[] listOfSpecificElement) {
        //Fill the arrayList with all my specfic object
        for (GameElement things : listOfSpecificElement) {
            allGameObject.add(things);
        }

    }

    /**
     * Create all character, all stuff then fill the collection of Game Element with a specific position
     */
    public void generateBoard(String difficult) {
        switch (difficult){
            case "1"->{
                generateTreasure(1.5);
                generateEnemy(0.5);
            }
            case "2"->{
                generateTreasure(1.3);
                generateEnemy(0.7);
            }
            case "3"->{
                generateTreasure(1);
                generateEnemy(1);
            }


        }

        fillTable(listOfCharacter);
        fillTable(listOfStuff);
        generatePosition(allGameObject);
    }

    /**
     * Create a position for each game element. Check if the position is occuped, then sort the collection
     * @param listOfElement
     */
    public void generatePosition(List<GameElement> listOfElement) {
        boolean freePosition = true;
        for (int i = 0; i < listOfElement.size(); i++) {
            int diceResult = diceMethods.launchDice(63) + 1; // Get a random position + 1 to disabled pop on 1st position

            for (int j = 0; j < listOfElement.size(); j++) {//check if the position is free, then give the position

                if (diceResult == listOfElement.get(j).getPosition()) {
                    i--;
                    freePosition = false;
                }
            }
            if (freePosition) {
                listOfElement.get(i).setPosition(diceResult);
            } else {
                freePosition = true;
            }
        }
        Collections.sort(listOfElement, (o1, o2) -> {
            if (o1.getPosition() < o2.getPosition()) {
                return -1;
            } else {
                return 0;
            }
        });

    }

    public void enemyPositionAfterLose(Character pEnemy) {//ATTENTION, c'est sur qu'il faudra gerer le cas ou il n'y a plus de case dispo derrière
        RollTheDice toto = this.getDiceMethods();
        int newPosition = toto.replaceDiceLaunch(pEnemy);
        boolean isNewPositionOk = true;
        for (GameElement enem : this.allGameObject
        ) {
            if (enem.getPosition() == newPosition) {
                isNewPositionOk = false;
            }

        }
        if (isNewPositionOk) {
            pEnemy.setPosition(newPosition);
        } else {

            enemyPositionAfterLose(pEnemy);
            return;
        }


//        for (GameElement enemies: this.allGameObject//position de tous les gameElement
//        ) {
//            System.out.println(enemies.getPosition());
//        }

//        System.out.println("l'ennemi à bouger est un " + pEnemy.getNature() + " en position " + pEnemy.getPosition() + ". Actuellement, il lui reste " + pEnemy.getHealth() + " PDV.");
//        System.out.println("Nouvelle position théorique de l'ennemi : " + newPosition);
//        System.out.println("Nouvelle position réelle de l'ennemi "+pEnemy.getPosition());


    }


    @Override
    public String toString() {
        String sentence = "";
        for (Character character : listOfCharacter) {
            sentence += character.getNature() + "\n";
        }
        for (Stuff stuff : listOfStuff) {
            sentence += stuff.getName() + "\n";
        }
        return sentence;
    }

    public Character[] getListOfCharacter() {
        return listOfCharacter;
    }

    public Stuff[] getListOfStuff() {
        return listOfStuff;
    }
}
