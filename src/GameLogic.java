public class GameLogic {
    private int attemptCount;
    private boolean isGameOver;

    public void initializeGame() {
        this.attemptCount = 0;
        this.isGameOver = false;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
