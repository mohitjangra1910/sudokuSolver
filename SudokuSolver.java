import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[9][9];

        System.out.println("Enter the Sudoku grid row by row (use '_' for missing numbers):");

        for (int i = 0; i < 9; i++) {
            String row = scanner.nextLine().replaceAll("\\s+", ""); 
            if (row.length() != 9) {
                System.out.println("Invalid row length. Please enter exactly 9 characters.");
                i--; 
                continue;
            }
            for (int j = 0; j < 9; j++) {
                board[i][j] = (row.charAt(j) == '_') ? 0 : Character.getNumericValue(row.charAt(j));
            }
        }
        scanner.close();

        System.out.println("\nOriginal Sudoku Grid:");
        printBoard(board);

        if (solveSudoku(board)) {
            System.out.println("\nSolved Sudoku Grid:");
            printBoard(board);
        } else {
            System.out.println("\nNo solution exists for the given Sudoku.");
        }
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print((board[i][j] == 0) ? "· " : board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) { 
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudoku(board)) {
                                return true; 
                            }

                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}

