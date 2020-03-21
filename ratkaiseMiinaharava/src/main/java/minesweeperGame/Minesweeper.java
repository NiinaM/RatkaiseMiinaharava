package minesweeperGame;

import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) {
        Player player1 = new Human();
        Gameboard game = new Gameboard(20, 20, 1);
        Player player2 = new Computer(20,20);
        playMinesweeper(game, player2);
        //game.getBoard()[3][3].setUnlocked();
        //game.printGameSituation();
    }

    private static void playMinesweeper(Gameboard gameboard, Player player) {
        Boolean gameOver = false;
        int lockedCells = gameboard.getHeight() * gameboard.getWidth();
        while (!gameOver) {
            gameboard.printGameSituation();
 
            if (gameboard.getAmountOfBombs() == lockedCells) {
                System.out.println("Voitit pelin!");
                break;
            }
            
            int[] playerInputs = player.getNext();
            int x = playerInputs[0];
            int y = playerInputs[1];
            int selectedChoice = playerInputs[2];

            Cell cell = gameboard.getBoard()[x][y];
            
            if (!cell.getUnlocked()) {
                if (selectedChoice == 0) {
                    cell.setFlag();
                } else if (selectedChoice == 1) {
                    cell.setUnlocked();
                    lockedCells--;
                    
                    if (cell.getIsItBomb()) {
                        gameOver = true;
                        System.out.println("Osuit pommiin, hävisit pelin!");
                        gameboard.printGameSituation();
                    }
                }
            }
        }
    }
}
