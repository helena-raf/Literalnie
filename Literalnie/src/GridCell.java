import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class GridCell extends JLabel {
    private char letter;
    private boolean empty;

    public GridCell() {
        this.empty = true;
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 2));
    }

    public void setLetter(char letter) {
        this.letter = letter;
        this.empty = false;
        String string = Character.toString(letter);
        this.setText(string.toUpperCase());
        this.setHorizontalAlignment(SwingConstants.CENTER); 
        this.setVerticalAlignment(SwingConstants.CENTER);  
        this.setFont(new Font("Arial", Font.BOLD, 30));
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
        this.setBorder(null);
        this.setForeground(Color.WHITE);
        if (color == MyColor.GREEN) {
            this.setBackground(new Color(97, 140, 86));
        }
        else if (color == MyColor.YELLOW) {
            this.setBackground(new Color(201, 177, 57));
        }
        else {
            this.setBackground(new Color(120, 124, 127));
        }
    }

}
