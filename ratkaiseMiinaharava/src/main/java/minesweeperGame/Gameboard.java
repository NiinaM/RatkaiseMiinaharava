package minesweeperGame;

import java.util.Random;

public class Gameboard {

    private int height;
    private int width;
    private int amountOfBombs;
    private Cell[][] board;

    public Gameboard(int height, int width, int amountOfBombs) {
        this.height = height;
        this.width = width;
        this.amountOfBombs = amountOfBombs;
        this.board = new Cell[this.width][this.height];
        // width on x-akselin mukainen ja height y-akselin mukainen
        this.initializeTheGame();
    }

    private void initializeTheGame() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                Cell cell = new Cell(i, j);
                this.board[i][j] = cell;
            }

        }
        this.setBombs();
        this.setTheNumberOfBombsAroundTheCell();

    }

    private void setBombs() {
        Random random = new Random();
        int bombsNow = this.amountOfBombs;
        while (bombsNow > 0) {
            int coordinateX = random.nextInt(this.width);
            int coordinateY = random.nextInt(this.height);

            Cell cell = this.board[coordinateX][coordinateY];
            if (!cell.getIsItBomb()) {
                cell.setBomb();
            }
            bombsNow--;
        }
    }

    private void setTheNumberOfBombsAroundTheCell() {

        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                Cell cell = this.board[i][j];
                int amountOfBombs = this.countTheBombs(cell);
                cell.setTheAmountOfBombsNearBy(amountOfBombs);
            }

        }
    }

    private int countTheBombs(Cell cell) {
        int bombCounter = 0;
        int coordinateX = cell.getCoordinateX();
        int coordinateY = cell.getCoordinateY();
        for (int i = coordinateX - 1; i <= coordinateX + 1; i++) {
            if (i < 0 || i >= this.width) {
                continue;
            }
            for (int j = coordinateY - 1; j <= coordinateY + 1; j++) {
                if (i == coordinateX && j == coordinateY) {
                    continue;
                }
                if (j < 0 || j >= this.height) {
                    continue;
                }
                Cell neighbourCell = this.board[i][j];
                if (neighbourCell.getIsItBomb()) {
                    bombCounter++;
                }
            }
        }
        return bombCounter;
    }

    public void printGameSituation() {
        System.out.print("  ");
        for (int i = 0; i < this.width; i++) {
            System.out.print(i + " ");
        }
        for (int j = 0; j < this.width; j++) {
            System.out.println("");
            System.out.print(j);
            for (int k = 0; k < this.height; k++) {
                Cell cell = this.board[j][k];
                System.out.print(" " + cell.toString());
            }

        }
    }

    @Override
    public String toString() {
        return "Width: " + this.width + "\n" + "Height: " + this.height + "\n" + "Bombs: " + this.amountOfBombs;
    }

}
