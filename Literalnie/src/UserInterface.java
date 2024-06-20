public class UserInterface {
    private Frame frame;
    private String lastGuess;
    public WordleGame game;

    public UserInterface(WordleGame game) {
        this.frame = new Frame(this);
        this.game = game;
    }

    public synchronized void userPressedEnter(String typedWord) {
        if (typedWord.length() < 5) {
            notifyWordTooShort();
        }
        else {
            this.lastGuess = typedWord.toLowerCase();
            notify();
        }
    }

    public void notifyWordTooShort() {
        frame.tooShortInfo();
    }

    public void notifyWordDoesNotExist() {
        frame.doesNotExistInfo();
    }

    public synchronized String getGuessFromUser() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return lastGuess;
    }

    public void nextRow() {
        this.frame.guessGrid.nextRow();
    }


   public void printColoredGuess(ColoredWord coloredGuess) {
        for (int i = 0; i < 5; i++) {
            MyColor color = coloredGuess.getColorFromPos(i);
            this.frame.guessGrid.colorCellInCurrentRow(i, color);
        }
    }
    public void handleWin(String correctWord) {
        frame.blockKeyboard();
        frame.blockInfoButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        frame.showWinMessage(correctWord);
        game.initializeNewGame();
    }

    public void handleLoss(String correctWord) {
        frame.blockKeyboard();
        frame.blockInfoButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        frame.showLossMessage(correctWord);
        game.initializeNewGame();
    }

    


   
}
