import javax.swing.JPanel;
import java.awt.*;

public class GuessGrid extends JPanel{
    private GridCell[][] grid;
    private int currentRow;
    private int currentCol;
    
    public GuessGrid(){
        this.grid = new GridCell[6][5];
        this.currentRow = 0;
        this.currentCol = 0;
        this.setLayout(new GridLayout(6, 5, 3, 3));
        
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++){
                grid[row][col] = new GridCell();
                this.add(grid[row][col]);
            }
        }
    }

    public void insertLetter(String letter){
        this.grid[currentRow][currentCol].setLetter(letter);
        if (currentCol == 4) {
            this.currentCol = 0;
            this.currentRow += 1;
        }
        else {
            this.currentCol += 1;
        }
    }
}
