import javax.swing.JLabel;
import java.awt.Color;

public class GridCell extends JLabel {
    private char letter;
    private boolean empty;

    public GridCell() {
        this.empty = true;
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
    }

    public void setLetter(char letter) {
        this.letter = letter;
        this.empty = false;
        this.setText(Character.toString(letter));
    }

    public void deleteLetter() {
        this.setText("");
        this.empty = true;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setColor(MyColor color) {
        if (color == MyColor.GREEN) {
            this.setBackground(Color.GREEN);
        }
        else if (color == MyColor.YELLOW) {
            this.setBackground(Color.YELLOW);
        }
        else {
            this.setBackground(Color.GRAY);
        }
    }

}
