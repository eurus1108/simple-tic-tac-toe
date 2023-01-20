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

        printGameBoard(grid);
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
}