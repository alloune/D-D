package GameCore;
import Char.Character;
import Char.Dragon;
import Char.Gobelin;
import Char.Sorcerer;
import GameCore.RollTheDice;


public class Board {
        private RollTheDice diceMethods = new RollTheDice();// a améliorer, on doit pouvoir le virer d'ici
        private Character[] listOfCharacter;
        private int enemyCount=5;
        public Board(){
                listOfCharacter = new Character[enemyCount];

        }

        public void generateEnemy(){
                for(int i =0; i < enemyCount; i++){
                       int diceResult = diceMethods.launchDice(3);
                       switch (diceResult){
                               case 1-> {listOfCharacter[i] = new Gobelin();listOfCharacter[i].setNature("gobelin");}
                               case 2-> {listOfCharacter[i] = new Dragon();listOfCharacter[i].setNature("dragon");}
                               case 3-> {listOfCharacter[i] = new Sorcerer(); listOfCharacter[i].setNature("sorcerer");}
                       }

                }


        }

    @Override
    public String toString() {
            String sentence = "";
            for(Character character : listOfCharacter){
                sentence += character.getNature()+"\n";
            }
        return sentence;
    }

    public Character[] getListOfCharacter() {
        return listOfCharacter;
    }
}
