public class UserInterface {
    private Frame frame;
    private String lastGuess;

    public UserInterface() {
        this.frame = new Frame(this);
    }

    public synchronized void userPressedEnter(String typedWord) {
        if (typedWord.length() < 5) {
            notifyWordTooShort();
        }
        else {
            this.lastGuess = typedWord;
            notify();
        }
    }

    public void notifyWordTooShort() {
        System.out.println("za krotkie");
    }

    ////////////////////////////////////////////////

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
   
}
