import java.util.Scanner;

public class UserInterface {

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
