public class WordleGame {
    public static void main(String[] args) {

        GameLogic gameLogic = new GameLogic();

        gameLogic.initializeGame();

        while (!gameLogic.isGameOver()) {
            // gracz zgaduje slowo 
            // ewaluacja slowa 
        }
        
        System.out.println("Game over!");
    }
}