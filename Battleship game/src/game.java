import java.util.Random;
import java.util.Scanner;

public class game {
    public static final int BOARD_SIZE = 10;
    public static final int NUM_SHIPS = 5;

    public static void main(String[] args) {
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
        int[] shipsX = new int[NUM_SHIPS];
        int[] shipsY = new int[NUM_SHIPS];


        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '.';
            }
        }


        Random random = new Random();
        for (int i = 0; i < NUM_SHIPS; i++) {
            shipsX[i] = random.nextInt(BOARD_SIZE);
            shipsY[i] = random.nextInt(BOARD_SIZE);
            board[shipsX[i]][shipsY[i]] = 'S';
        }


        int numHits = 0;
        int remainingShips = NUM_SHIPS;
        int totalGuesses = 0;
        Scanner scanner = new Scanner(System.in);
        while (numHits < NUM_SHIPS) {

            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println();


            System.out.print("Enter the row (0 - " + (BOARD_SIZE - 1) + "): ");
            int guessX = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the column (0 - " + (BOARD_SIZE - 1) + "): ");
            int guessY = Integer.parseInt(scanner.nextLine());
            totalGuesses++;

            if (board[guessX][guessY] == 'S') {
                System.out.println("HIT!");
                board[guessX][guessY] = 'H';
                numHits++;
                remainingShips--;
            } else {
                System.out.println("MISS!");
                board[guessX][guessY] = 'M';
            }
            System.out.println("Total Guesses: "+ totalGuesses);
            System.out.println("Remaining Ships : "+remainingShips);
        }
        System.out.println("You destroyed all battleships, You win !!");
    }
}
