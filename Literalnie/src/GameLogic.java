

public class GameLogic {
    private int attemptCount;
    private boolean isGameOver;
    private Word correctWord;
    private ColoredWord currentGuess;


    public void initializeGame() {
        this.attemptCount = 0;
        this.isGameOver = false;
        // pozniej correctWord ma byc losowane!
        this.correctWord = new Word("rzeka");
        //////////////////////
    }

    public void setCurrentGuess(String guess) {
        this.currentGuess = new ColoredWord(guess);
    }

    public ColoredWord getCurrentGuess() {
        return currentGuess;
    }

    public boolean isGuessCorrect() {
        for (int i = 0; i < 5; i++) {
            if (correctWord.getCharFromPos(i) != currentGuess.getCharFromPos(i)) {
                return false;
            }
        }
        return true;
    }

    public void evaluateGuess(String guess) {
        setCurrentGuess(guess);
        this.attemptCount += 1;
        this.colorGuess();
        if (isGuessCorrect()) {
            this.isGameOver = true;
        }
        else if (isAttemptsLimitReached()) {
            this.isGameOver = true;
        }
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
        return (attemptCount >= 6);
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
