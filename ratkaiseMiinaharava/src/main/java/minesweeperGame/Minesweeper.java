package minesweeperGame;

public class Minesweeper {

    public static void main(String[] args) {
        Gameboard game = new Gameboard(8,8,8);
        game.printGameSituation();
    }
}
