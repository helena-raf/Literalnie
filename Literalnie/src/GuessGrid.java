import javax.swing.JPanel;
import java.awt.*;

public class GuessGrid extends JPanel{
    private GridCell[][] grid;
    // current col i row wskazuja kolejne puste miejsce w kratce
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

    public void deleteLetter() {
        prevCell();
        this.grid[currentRow][currentCol].deleteLetter();
    }

    public void insertLetter(String letter){
        // musimy sprawdzic czy nie jestesmy w komorce poza kratka == czy kratka nie jest pelna
        if (currentRow != 6) {
            this.grid[currentRow][currentCol].setLetter(letter);
            nextCell();
        }
    }

    private void nextCell() {
        if (currentCol == 4) {
            if (currentRow == 6) {return;} // pozwala wyjsc tylko jedno pole poza kratke (jak juz reszta wypelniona)
            this.currentCol = 0;
            this.currentRow += 1;
        }
        else {
            this.currentCol += 1;
        }
    }

    private void prevCell() {
        if (currentCol == 0) {
            if (currentRow == 0) {return;}
            this.currentCol = 4;
            this.currentRow -= 1;
        }
        else {
            currentCol -= 1;
        }
    }
}
