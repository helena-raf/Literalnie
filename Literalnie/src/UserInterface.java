import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.*;


public class UserInterface {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel guessGrid;

    public UserInterface() {
        this.frame = new JFrame();
        this.mainPanel = new JPanel();
        this.guessGrid = new GuessGrid();

        setUpMainPanel();
        setUpFrame();

        frame.setVisible(true);
    }

    private void setUpMainPanel() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(guessGrid);
    }

    private void setUpFrame() { 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 400));;
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);       
    }

    ////////////////////////////////////////////////

    public String getGuessFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\npodaj zgadywane slowo: ");
        String guess = scanner.nextLine();
        return guess;
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
