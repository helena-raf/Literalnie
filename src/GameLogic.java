import java.util.Dictionary;

public class GameLogic {
    private int attemptCount;
    private boolean isGameOver;
    private WordDictionary dictionary;
    private Word correctWord;
    private ColoredWord currentGuess;

    public void initializeGame() {
        this.attemptCount = 0;
        this.isGameOver = false;
        // pozniej correctWord ma byc losowane!
        this.correctWord = new Word("rzeka");
        //////////////////////
    }

    public void setCurrentGuess(ColoredWord guess) {
        this.currentGuess = guess;
    }

    public boolean isGuessCorrect() {
        for (int i = 0; i < 5; i++) {
            if (correctWord.getCharFromPos(i) != currentGuess.getCharFromPos(i)) {
                return false;
            }
        }
        return true;
    }

    public void evaluateGuess() {
        // sprawdzic czy slowo istnieje jesli nie -> handleInvGuessInput jesli tak 
        // sprawdzic czy slowo dobre jesli tak -> handleWin jesli nie
        // isAttemptsLimitReached jesli tak -> gameover jesli nie 
        //  colorguess
    }

    public void colorGuess() {
        for (int i = 0; i < 5; i++) {
            char correctLetter = correctWord.getCharFromPos(i);
            char guessLetter = currentGuess.getCharFromPos(i);

            if (currentGuess.isLetterAtPosition(correctLetter, i)) {
                currentGuess.colorLetterAtPos(i, Color.GREEN);
            }
            else {
                if (correctWord.containsLetter(guessLetter)) {
                    currentGuess.colorLetterAtPos(i, Color.YELLOW);
                }
            }
        }
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
