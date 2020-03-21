package minesweeperGame;

import java.util.Scanner;

public class Human implements Player {

    private Scanner scanner;

    public Human() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int[] getNext() {
        System.out.println("Anna koordinaatti x: ");
        int x = scanner.nextInt();
        System.out.println("Anna koordinaatti y: ");
        int y = scanner.nextInt();
        System.out.println("Haluatko asettaa lipun? Kirjoita '0', jos haluat. Haluatko avata ruudun? Kirjoita '1', jos haluat.");
        int selectedChoice = scanner.nextInt();
        
        int[] playerInputs = new int[3];
        playerInputs[0] = x;
        playerInputs[1] = y;
        playerInputs[2] = selectedChoice;
        
        return playerInputs;
    }

}
