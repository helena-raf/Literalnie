import java.util.Scanner;
import javax.swing.*;


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
            this.frame.nextRow();
            notify();
        }
    }

    public void notifyWordTooShort() {}
    

    ////////////////////////////////////////////////

    public synchronized String getGuessFromUser() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return lastGuess;
    }

   public void printColoredGuess(ColoredWord coloredGuess) {
        for (int i = 0; i < 5; i++) {
            Letter letter = coloredGuess.getLetterFromPos(i);
            Color color = letter.getColor();
            String colorStr;
            if (color == Color.GREEN) {
                colorStr = "GREEN_";
            }
            else if (color == Color.YELLOW) {
                colorStr = "YELLOW_";
            }
            else {
                colorStr = "GREY_";
            }
            System.out.print(colorStr+ letter.getChar()+ "  ");
        }
   }

}
