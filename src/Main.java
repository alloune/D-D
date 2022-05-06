import Char.Hero;
import GameCore.Board;
import GameCore.StartMenu;
import GameCore.Game;
public class Main {
    public static void main(String[] args) {
        //Initialize all game component
        StartMenu launch = new StartMenu();
        Hero hero = null;
        Game coreGame = new Game(launch);
        Board board = new Board();
        board.generateEnemy();
        System.out.println(board);
        // Start the game, iterative method
        coreGame.cyclingGame(hero);

    }
}

