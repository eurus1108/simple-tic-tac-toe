import java.util.Scanner;

public class Main {
    private static char[][] grid = new char[3][3];

    public static void main(String[] args) {
        // Fill game board with spaces
        initializeGrid();
        // Print the initial game grid
        printGameBoard();

        // Tracks the number of exchange
        int counter = 0;

        while (true) {
            if (counter % 2 == 0) {
                takeCoordinate('X');
            }

            if (counter % 2 != 0) {
                takeCoordinate('O');
            }

            counter++;
            printGameBoard();

            // Analyze the game state and print the result
            boolean xWins = checkForWin(grid, 'X');
            boolean oWins = checkForWin(grid, 'O');
            boolean isArrayFull = isArrayFull();

            if (xWins) {
                System.out.println("X wins");
                break;
            } else if (oWins) {
                System.out.println("O wins");
                break;
            } else if (isArrayFull) {
                System.out.println("Draw");
                break;
            } else {
                continue;
            }
        }
    }

    public static void initializeGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public static void takeCoordinate(char player) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to make a move
        while (true) {
            System.out.println("Enter the coordinates: ");
            String coordinates = scanner.nextLine();
            String[] parts = coordinates.split(" ");

            // Check for correct input format
            if (parts.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            // Check for correct coordinates
            int x, y;
            try {
                x = Integer.parseInt(parts[0]);
                y = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (x < 1 || x > 3 || y < 1 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            // Check if the cell is already occupied
            if (grid[x - 1][y - 1] == 'X' || grid[x - 1][y - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            // Update the grid and print it
            grid[x - 1][y - 1] = player;
            printGameBoard();
            break;
        }
    }

    private static void printGameBoard() {
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

    public static boolean isArrayFull() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    // Check if the given player has won the game
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
