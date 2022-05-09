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
    private int enemyCount = 10;
    private int treasureCount = 10;
    private int totalOfObject = enemyCount + treasureCount;
    private List<GameElement> allGameObject = new ArrayList<GameElement>(totalOfObject);

    public Board() {
        listOfCharacter = new Character[enemyCount];
        listOfStuff = new Stuff[treasureCount];
    }

    public RollTheDice getDiceMethods() {
        return diceMethods;
    }

    public void setDiceMethods(RollTheDice diceMethods) {
        this.diceMethods = diceMethods;
    }

    public void setListOfCharacter(Character[] listOfCharacter) {
        this.listOfCharacter = listOfCharacter;
    }

    public void setListOfStuff(Stuff[] listOfStuff) {
        this.listOfStuff = listOfStuff;
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public void setEnemyCount(int enemyCount) {
        this.enemyCount = enemyCount;
    }

    public int getTreasureCount() {
        return treasureCount;
    }

    public void setTreasureCount(int treasureCount) {
        this.treasureCount = treasureCount;
    }

    public int getTotalOfObject() {
        return totalOfObject;
    }

    public void setTotalOfObject(int totalOfObject) {
        this.totalOfObject = totalOfObject;
    }

    public List<GameElement> getAllGameObject() {
        return allGameObject;
    }

    public void setAllGameObject(List<GameElement> allGameObject) {
        this.allGameObject = allGameObject;
    }

    public void generateEnemy() {
        for (int i = 0; i < enemyCount; i++) {
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

    public void generateTreasure() {
        for (int i = 0; i < treasureCount; i++) {
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

    public void fillTable(GameElement[] listOfSpecificElement, List<GameElement> tableToFill) {
        //Fill the arrayList with all my specfic object
        for (GameElement things : listOfSpecificElement) {
            tableToFill.add(things);
        }

    }

    public void generateBoard() {
        generateTreasure();
        generateEnemy();
        fillTable(listOfCharacter, allGameObject);
        fillTable(listOfStuff, allGameObject);
        generatePosition(allGameObject);
    }

    public void generatePosition(List<GameElement> listOfElement) {
        int diceCount = 0;
        boolean freePosition = true;
        for (int i = 0; i < listOfElement.size(); i++) {
            int diceResult = diceMethods.launchDice(63) + 1; // Get a random position + 1 to disabled pop on 1st position

            for (int j = 0; j < listOfElement.size(); j++) {//check if the position is free, then give the position

                if (diceResult == listOfElement.get(j).getPosition()) {
                    i--;
                    diceCount++;
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
        for (GameElement element: listOfElement) {
            System.out.print(element.getPosition()+ "--");
        }
//        for(GameElement element : listOfElement){
//            System.out.println(element.getPosition());
//        }
//        System.out.println("Taille de la liste d'element : "+listOfElement.size());
//        System.out.println("Mise a jour des positions en " + diceCount +" lancé de dés");

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
