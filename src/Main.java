import GameCore.Request;
import GameElement.Char.Hero;
import GameCore.Board;
import GameCore.StartMenu;
import GameCore.Game;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        //Initialize all game component
        Request newConnexion = new Request();
        try {
            Statement test = newConnexion.connect();
            ResultSet answer = newConnexion.request("SELECT * FROM hero", test);
            while(answer.next()){
                System.out.println("************************************");
                System.out.println(answer.getString("Name"));
                System.out.println(answer.getString("Classe"));
                System.out.println(answer.getString("Hp")+ " Point de vie");
                System.out.println(answer.getString("Strength")+ " Point de force");
                System.out.println("************************************");

            }

        } catch (Exception e) {
            System.err.println(e);
        }

        StartMenu launch = new StartMenu();
        Hero hero = null;
        Board board = new Board();
        Game coreGame = new Game(launch, board);
        board.generateBoard("3");
        //Start the game, iterative method
        coreGame.cyclingGame(hero);


    }
}

