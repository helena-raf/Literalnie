public class WordleGame {
    private GameLogic gameLogic;
    private UserInterface userInterface;

    public WordleGame() {
        this.gameLogic = new GameLogic();
        this.userInterface = new UserInterface();
    }

    public void initializeNewGame() {
        gameLogic.initializeGame();
       

        while (!gameLogic.isGameOver()) {
            gameLogic.setCurrentGuess(userInterface.getGuessFromUser());
            gameLogic.evaluateGuess();
            userInterface.printColoredGuess(gameLogic.getCurrentGuess());
        }

        
        System.out.println("Game over!");
        // czekamy na input czy chce grac ponownie jesli tak to this.initializeNewGame
    }

        
    public static void main(String[] args) {
        WordleGame game = new WordleGame();
        game.initializeNewGame();
    }
}