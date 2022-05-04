import Char.Hero;
import GameCore.StartMenu;
import GameCore.Game;

public class Main {
    public static void main(String[] args) {
        StartMenu launch = new StartMenu();
        Game coreGame = new Game();
        Hero hero;
        launch.start();
        hero = launch.charSelection();
        coreGame.coreGame(hero, launch);
        coreGame.restartGame();
    }
}

