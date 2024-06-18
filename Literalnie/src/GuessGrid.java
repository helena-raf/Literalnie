import javax.swing.JPanel;
import java.awt.*;

public class GuessGrid extends JPanel{
    private GridCell[][] grid;
    // current col i row wskazuja kolejne puste miejsce w kratce
    private int currentRow;
    private int currentCol;
    
    public GuessGrid(){
        this.setBackground(new Color(255, 100, 50));
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

    public void insertLetter(char letter){
        // musimy sprawdzic czy nie jestesmy w komorce poza kratka == czy wiersz nie jest pelny
        if (currentCol <= 4) {
            this.grid[currentRow][currentCol].setLetter(letter);
            nextCell();
        }
    }

    public String getWord() {
        char[] chars = new char[5];
        int row = this.currentRow;
        if (currentCol == 0) {return "";}
        int lastLetterColumn = currentCol - 1;

        for (int col = 0; col <= lastLetterColumn; col++) {
            GridCell cell = grid[row][col];
            if (!cell.isEmpty()) {
                chars[col] = cell.getLetter();
            }
        }
        String word = new String(chars, 0, lastLetterColumn+1);
        return word;
    }

    private void nextCell() {
    // pozwala wyjsc tylko jedno pole w prawo poza kratke
        if (currentCol <= 4) {
            this.currentCol += 1;
        }
    }

    private void prevCell() {
        if (currentCol != 0) {
            this.currentCol -= 1;
        }
    }

    public void nextRow() {
        this.currentCol = 0;
        this.currentRow += 1;
    }

    public void colorCellInCurrentRow(int column, MyColor color) {
        this.grid[currentRow][column].setColor(color);
    }

}
