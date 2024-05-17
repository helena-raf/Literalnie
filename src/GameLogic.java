public class GameLogic {
    private int attemptCount;
    private boolean isGameOver;

    public void initializeGame() {
        attemptCount = 0;
        isGameOver = false;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
