public class App {
    public static void main(String[] args) throws Exception {
        Sudoku game = new Sudoku();
        game.initializeBoard(args);
        System.out.println("Tabuleiro inicial:");
        game.printBoard();
        game.play();
    }
}
