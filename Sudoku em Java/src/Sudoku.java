import java.util.Scanner;

public class Sudoku {
    private int[][] board;
    private boolean[][] fixed;

    public Sudoku() {
        board = new int[9][9];
        fixed = new boolean[9][9];
    }

    public void initializeBoard(String[] args) {
        for (String arg : args) {
            String[] parts = arg.split(";");
            if (parts.length == 3) {
                try {
                    String[] pos = parts[0].split(",");
                    int row = Integer.parseInt(pos[0]);
                    int col = Integer.parseInt(pos[1]);
                    int value = Integer.parseInt(parts[1]);
                    boolean isFixed = Boolean.parseBoolean(parts[2]);

                    if (isValidPosition(row, col) && isValidValue(value)) {
                        board[row][col] = value;
                        fixed[row][col] = isFixed;
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Erro ao processar argumento: " + arg);
                }
            }
        }
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 9 && col >= 0 && col < 9;
    }

    private boolean isValidValue(int value) {
        return value >= 1 && value <= 9;
    }

    public boolean isValidMove(int row, int col, int value) {
        if (!isValidPosition(row, col) || !isValidValue(value) || fixed[row][col] || board[row][col] != 0) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean makeMove(int row, int col, int value) {
        if (isValidMove(row, col, value)) {
            board[row][col] = value;
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("- - - - - - - - - - -");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                if (board[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean isBoardComplete() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] findEmptyCell() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0 && !fixed[i][j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public boolean solve() {
        int[] empty = findEmptyCell();
        if (empty == null) {
            return true;
        }

        int row = empty[0];
        int col = empty[1];

        for (int num = 1; num <= 9; num++) {
            if (isValidMove(row, col, num)) {
                board[row][col] = num;
                if (solve()) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (!isBoardComplete()) {
            printBoard();
            System.out.println("Insira o número da linha (entre 0 e 8), insira o número da coluna (entre 0 e 8) e  depois digite um número (entre 1 e 9). Devem ser separados por espaço. Ex: 0 1 5");
            System.out.println("Se quiser a resposta do jogo, digite 'resposta'.");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("resposta")) {
                if (solve()) {
                    System.out.println("Tabuleiro resolvido:");
                    printBoard();
                } else {
                    System.out.println("Não foi possível resolver o tabuleiro.");
                }
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length == 3) {
                try {
                    int row = Integer.parseInt(parts[0]);
                    int col = Integer.parseInt(parts[1]);
                    int value = Integer.parseInt(parts[2]);

                    if (makeMove(row, col, value)) {
                        System.out.println("Movimento realizado.");
                    } else {
                        System.out.println("Movimento inválido. Tente novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Use números inteiros.");
                }
            } else {
                System.out.println("Formato inválido. Use: linha coluna valor");
            }
        }

        if (isBoardComplete()) {
            System.out.println("Parabéns! Tabuleiro completo:");
            printBoard();
        }
        scanner.close();
    }


}