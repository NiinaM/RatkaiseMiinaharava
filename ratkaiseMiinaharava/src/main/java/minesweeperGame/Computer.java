package minesweeperGame;

import java.util.Random;

public class Computer implements Player {

    private int width;
    private int height;
    private Random random;

    public Computer(int width, int height) {
        this.width = width;
        this.height = height;
        random = new Random();
    }

    @Override
    public int[] getNext() {
        int[] playerInputs = new int[3];
        playerInputs[0] = this.random.nextInt(this.width);
        playerInputs[1] = this.random.nextInt(this.height);
        playerInputs[2] = this.random.nextInt(2);

        return playerInputs;
    }

}
