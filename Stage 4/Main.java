import java.util.Scanner;

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

        // print the initial game grid
        printGameBoard(grid);

        // prompt the user to make a move
        while (true) {
            System.out.print("Enter the coordinates: ");
            String coordinates = scanner.nextLine();
            String[] parts = coordinates.split(" ");

            // check for correct input format
            if (parts.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            // check for correct coordinates
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
            // check if the cell is already occupied
            if (grid[x - 1][y - 1] == 'X' || grid[x - 1][y - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            // update the grid and print it
            // playerInput = playerInput.substring(0, index) + "X" +
            // playerInput.substring(index + 1);
            grid[x - 1][y - 1] = 'X';
            printGameBoard(grid);
            break;
        }
    }

    private static void printGameBoard(char[][] grid) {
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
}
