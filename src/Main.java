import GameElement.Char.Hero;
import GameCore.Board;
import GameCore.StartMenu;
import GameCore.Game;
public class Main {
    public static void main(String[] args) {
        //Initialize all game component
        StartMenu launch = new StartMenu();
        Hero hero = null;
        Board board = new Board();
        Game coreGame = new Game(launch, board);
        board.generateBoard();
//        System.out.println(board);
        // Start the game, iterative method
        coreGame.cyclingGame(hero);

    }
}

