public class WordleGame {
    private GameLogic gameLogic;

    public WordleGame() {
        this.gameLogic = new GameLogic();
    }

    public void initializeNewGame() {
        gameLogic.initializeGame();

        while (!gameLogic.isGameOver()) {
            // gracz zgaduje slowo 
            // ewaluacja slowa 
        }
        
        System.out.println("Game over!");
        // czekamy na input czy chce grac ponownie jesli tak to this.initializeNewGame
    }

        
    public static void main(String[] args) {
        WordleGame game = new WordleGame();
        game.initializeNewGame();
    }
}