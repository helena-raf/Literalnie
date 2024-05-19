import java.util.Scanner;

public class UserInterface {

    public String getGuessFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("podaj zgadywane slowo: ");
        String guess = scanner.nextLine();
        return guess;
    }


}
