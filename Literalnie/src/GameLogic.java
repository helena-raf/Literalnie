import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private int attemptCount;
    private boolean isGameOver;
    private Word correctWord;
    private ColoredWord currentGuess;
    private boolean hasPlayerWon;


    public void initializeGame(String correctWord) {
        this.attemptCount = 0;
        this.isGameOver = false;
        this.hasPlayerWon = false;
        this.correctWord = new Word(correctWord);
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
            this.hasPlayerWon = true;
            this.isGameOver = true;
        }
        else if (isAttemptsLimitReached()) {
            this.isGameOver = true;
        }
    }

    public void colorGuess() {
        List<Character> correctLetters = new ArrayList<>();
        // lista lettersToCompare zawiera literki ktore bedziemy usuwac po porownaniu ich
        for (int i = 0; i < 5; i++) {
            char correctLetter = correctWord.getCharFromPos(i);
            correctLetters.add(correctLetter);
        }

        for (int i = 0; i < 5; i++) {
            char correctLetter = correctWord.getCharFromPos(i);
            char guessLetter = currentGuess.getCharFromPos(i);

            if (currentGuess.isLetterAtPosition(correctLetter, i)) {
                currentGuess.colorLetterAtPos(i, MyColor.GREEN);
                correctLetters.remove((Character) correctLetter);
            }

            else if (correctLetters.contains(guessLetter)) {
                currentGuess.colorLetterAtPos(i, MyColor.YELLOW);
                correctLetters.remove((Character) guessLetter);
            }
        }
    }


    public boolean isAttemptsLimitReached() {
        return (attemptCount >= 6);
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean hasPlayerWon() {
        return hasPlayerWon;
    }

    public Word getCorrectWord() {
        return correctWord;
    }
}
