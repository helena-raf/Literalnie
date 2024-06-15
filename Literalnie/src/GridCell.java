import javax.swing.JLabel;
import java.awt.Color;

public class GridCell extends JLabel {

    public GridCell() {
        this.setOpaque(true);
        this.setBackground(Color.GREEN);
    }

    public void setLetter(String letter) {
        this.setText(letter);
    }

}
