import java.util.Scanner;

import javax.swing.plaf.metal.OceanTheme;

public class Main {
    public static void main(String[] args) {
        char[][] grid = new char[3][3];

        Scanner scanner = new Scanner(System.in);
        String playerInput = scanner.nextLine();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = playerInput.charAt(i * 3 + j);
            }
        }

        printGameBoard(grid);

        boolean oWins = checkForWin(grid, 'O');
        boolean xWins = checkForWin(grid, 'X');

        int oCount = 0;
        int xCount = 0;
        for (int i = 0; i < 9; i++) {
            if (playerInput.charAt(i) == 'X') {
                oCount++;
            }
            if (playerInput.charAt(i) == 'O') {
                xCount++;
            }
        }

        if (oWins && xWins || xCount - oCount >= 2 || oCount - xCount >= 2) {
            System.out.println("Impossible");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (xWins) {
            System.out.println("X wins");
        } else if (playerInput.indexOf('_') == -1) {
            System.out.println("Impossible");
        } else {
            System.out.println("Game not finished");
        }
    }

    public static void printGameBoard(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean checkForWin(char[][] grid, char player) {
        // Check for horizontal win
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) {
                return true;
            }
        }

        // Check for vertical win
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] == player && grid[1][j] == player && grid[2][j] == player) {
                return true;
            }
        }

        // Check for diagonal win
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            return true;
        }
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) {
            return true;
        }

        return false;
    }
}