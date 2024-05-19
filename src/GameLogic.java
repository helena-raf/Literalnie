import java.util.Dictionary;

public class GameLogic {
    private int attemptCount;
    private boolean isGameOver;
    private WordDictionary dictionary;
    private char[] correctWord;
    private Word currentGuess;

    public void initializeGame() {
        this.attemptCount = 0;
        this.isGameOver = false;
        // pozniej correctWord ma byc losowane!
        char[] w = {'r', 'z', 'e', 'k', 'a'};
        this.correctWord = w;
        //////////////////////
    }

    public void setCurrentGuess(Word guess) {
        this.currentGuess = guess;
    }

    public boolean isGuessCorrect() {
        for (int i = 0; i < 5; i++) {
            if (correctWord[i] != currentGuess.getCharFromPos(i)) {
                return false;
            }
        }
        return true;
    }

    public void evaluateGuess() {
        // sprawdzic czy slowo istnieje jesli nie -> handleInvGuessInput jesli tak 
        // sprawdzic czy slowo dobre jesli tak -> handleWin jesli nie
        
    }

    public boolean isAttemptsLimitReached() {
        return (attemptCount >= 5);
    }

    public void handleWin() {

    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
